package com.hanifkf.revisifootbalmatch


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.google.gson.Gson
import com.hanifkf.revisifootbalmatch.Adapter.ScoreAdapter
import com.hanifkf.revisifootbalmatch.ApiRepository.ApiRepository
import com.hanifkf.revisifootbalmatch.Model.Score
import com.hanifkf.revisifootbalmatch.Presenter.PrevPresenter
import com.hanifkf.revisifootbalmatch.View.MainView
import kotlinx.android.synthetic.main.fragment_prev.view.*
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PrevFragment : Fragment(), MainView {


    private var score: MutableList<Score> = mutableListOf()
    private lateinit var presenter: PrevPresenter
    private var progressBar21: ProgressBar? = null
    private var swipeRefresh2: SwipeRefreshLayout? = null
    private lateinit var adapter: ScoreAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_prev, container, false)

        val request = ApiRepository()
        val gson = Gson()
        adapter = ScoreAdapter(ctx, score){
            startActivity<DetailActivity>("eventId" to it.eventId, "homeTeamId" to it.homeTeamId, "awayTeamId" to it.awayTeamId, "eventDate" to it.eventDate, "homeScore" to it.homeScore,
                "homeTeam" to it.homeTeam, "awayScore" to it.awayScore, "awayTeam" to it.awayTeam)
        }
        view.recycle_prev.layoutManager = LinearLayoutManager(ctx)
        view.recycle_prev.adapter = adapter
        presenter = PrevPresenter(this, request,gson)
        presenter.matchPrev()
        progressBar21 = view.findViewById(R.id.progressBar1)
        swipeRefresh2 = view.findViewById(R.id.swipeRefresh)
        swipeRefresh2?.setOnRefreshListener {
            score.clear()
            presenter.matchPrev()
        }
        return view
    }

    override fun showLoading() {
        swipeRefresh2?.isRefreshing = true
        Log.d("showLoading ","Shoo")
    }

    override fun hideLoading() {
        swipeRefresh2?.isRefreshing = false
        Log.d("hideLoading ","Hide")
    }

    override fun showMatch(data: List<Score>?) {
        swipeRefresh2?.isRefreshing = false
        if(data!=null){
            Log.d("showMatch ",data.size.toString())
            score.clear()
            score.addAll(data)
            adapter.notifyDataSetChanged()
        }


    }


}
