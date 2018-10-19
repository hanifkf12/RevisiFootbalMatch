package com.hanifkf.revisifootbalmatch.View

import com.hanifkf.revisifootbalmatch.Model.Score

interface MainView{
    fun showLoading()
    fun hideLoading()
    fun showMatch(data : List<Score>?)
}