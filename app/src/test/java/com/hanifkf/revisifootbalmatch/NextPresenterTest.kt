package com.hanifkf.revisifootbalmatch

import android.util.Log
import com.google.gson.Gson
import com.hanifkf.revisifootbalmatch.ApiRepository.ApiRepository
import com.hanifkf.revisifootbalmatch.ApiRepository.TheSportDBApi
import com.hanifkf.revisifootbalmatch.Model.Score
import com.hanifkf.revisifootbalmatch.Presenter.NextPresenter
import com.hanifkf.revisifootbalmatch.Response.ScoreResponse
import com.hanifkf.revisifootbalmatch.View.MainView
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.test.TestCoroutineContext
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class NextPresenterTest{

    private lateinit var presenter: NextPresenter

    @Mock
    private
    lateinit var view:MainView

    @Mock
    private
    lateinit var  gson: Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        presenter = NextPresenter(view, apiRepository ,gson , TestContextProvider())
    }

    @Test
    fun testGetNextMatch(){
        val score:MutableList<Score> = mutableListOf()
        val response = ScoreResponse(score)

        `when`(
            gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getNextUrl()),
                ScoreResponse::class.java

            )
        ).thenReturn(response)
        presenter.matchNext()
        verify(view).showLoading()
        verify(view).hideLoading()
        launch {
            verify(view).showMatch(score)
        }

    }

}