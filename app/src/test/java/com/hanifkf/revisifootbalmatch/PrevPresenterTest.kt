package com.hanifkf.revisifootbalmatch

import com.google.gson.Gson
import com.hanifkf.revisifootbalmatch.ApiRepository.ApiRepository
import com.hanifkf.revisifootbalmatch.Model.Score
import com.hanifkf.revisifootbalmatch.Presenter.NextPresenter
import com.hanifkf.revisifootbalmatch.Presenter.PrevPresenter
import com.hanifkf.revisifootbalmatch.Response.ScoreResponse
import com.hanifkf.revisifootbalmatch.View.MainView
import kotlinx.coroutines.experimental.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class PrevPresenterTest{

    private lateinit var presenter: PrevPresenter

    @Mock
    private lateinit var view: MainView

    @Mock
    private lateinit var  gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        presenter = PrevPresenter(view, apiRepository ,gson , TestContextProvider())
    }

    @Test
    fun testGetNextMatch(){
        val score:MutableList<Score> = mutableListOf()
        val response = ScoreResponse(score)

        Mockito.`when`(
            gson.fromJson(
                apiRepository
                    .doRequest("https://www.thesportsdb.com/api/v1/json/1/eventpastleague.php?id=4328"),
                ScoreResponse::class.java
            )
        ).thenReturn(response)
        presenter.matchPrev()

        verify(view).showLoading()
        verify(view).hideLoading()
        launch {
            verify(view).showMatch(score)
        }

    }
}