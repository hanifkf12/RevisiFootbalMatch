package com.hanifkf.revisifootbalmatch


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hanifkf.revisifootbalmatch.Adapter.FavoriteAdapter
import com.hanifkf.revisifootbalmatch.Database.database
import com.hanifkf.revisifootbalmatch.Model.Favorite
import kotlinx.android.synthetic.main.fragment_favorite.view.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.startActivity


class FavoriteFragment : Fragment() {
    private var favorites: MutableList<Favorite> = mutableListOf()
    private lateinit var adapter: FavoriteAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)

        view.recycle_fav.layoutManager = LinearLayoutManager(ctx)
        adapter = FavoriteAdapter(ctx, favorites) {
            startActivity<DetailActivity>("eventId" to it.idEvent, "homeTeamId" to it.idHome, "awayTeamId" to it.idAway,
                "eventDate" to it.date, "homeScore" to it.scoreHome, "homeTeam" to it.homeTeam, "awayScore" to it.awayScore, "awayTeam" to it.awayTeam)
        }
        view.recycle_fav.adapter = adapter
        showFavorite(view)
        view.swipeRefresh3.setOnRefreshListener {
            favorites.clear()
            showFavorite(view)
        }
        return view
    }

    private fun showFavorite(view: View) {
        context?.database?.use {
            view.swipeRefresh3.isRefreshing = false
            val result = select(Favorite.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<Favorite>())
            favorites.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }
}
