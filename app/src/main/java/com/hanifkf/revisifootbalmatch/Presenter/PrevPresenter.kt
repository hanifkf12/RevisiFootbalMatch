package com.hanifkf.revisifootbalmatch.Presenter

import com.google.gson.Gson
import com.hanifkf.revisifootbalmatch.ApiRepository.ApiRepository
import com.hanifkf.revisifootbalmatch.ApiRepository.TheSportDBApi
import com.hanifkf.revisifootbalmatch.CoroutineContextProvider
import com.hanifkf.revisifootbalmatch.Response.ScoreResponse
import com.hanifkf.revisifootbalmatch.View.MainView
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class PrevPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson,private val context: CoroutineContextProvider = CoroutineContextProvider()
){
    fun matchPrev(){
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRepository.doRequest(TheSportDBApi.getPrev()), ScoreResponse::class.java)
            }
                view.hideLoading()
                view.showMatch(data.await().events)

        }
    }
}
