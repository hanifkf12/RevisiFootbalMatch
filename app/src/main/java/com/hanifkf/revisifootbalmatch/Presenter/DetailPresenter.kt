package com.hanifkf.revisifootbalmatch.Presenter

import com.google.gson.Gson
import com.hanifkf.revisifootbalmatch.ApiRepository.ApiRepository
import com.hanifkf.revisifootbalmatch.ApiRepository.TheSportDBApi
import com.hanifkf.revisifootbalmatch.CoroutineContextProvider
import com.hanifkf.revisifootbalmatch.Response.DetailResponse
import com.hanifkf.revisifootbalmatch.Response.TeamResponse
import com.hanifkf.revisifootbalmatch.View.DetailView
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailPresenter(private val view: DetailView,
                      private val apiRepository: ApiRepository, private  val gson: Gson,
                      private val context: CoroutineContextProvider = CoroutineContextProvider()
){

    fun getDetail(id:String, idHome:String, idAway:String){
        view.showLoading()
        async (context.main){
            val data = bg {
                gson.fromJson(apiRepository.doRequest(TheSportDBApi.getDetail(id)), DetailResponse::class.java)
            }
            val homeTeam = bg {
                gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamDetail(idHome)), TeamResponse::class.java)
            }
            val awayTeam = bg {
                gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamDetail(idAway)), TeamResponse::class.java)
            }
                view.hideLoading()
                view.showMatch(data.await().events!!, homeTeam.await().teams!!, awayTeam.await().teams!!)

        }
    }
}