package com.hanifkf.revisifootbalmatch.View

import com.hanifkf.revisifootbalmatch.Model.Detail
import com.hanifkf.revisifootbalmatch.Model.Score
import com.hanifkf.revisifootbalmatch.Model.Team

interface DetailView {
    fun showLoading()
    fun hideLoading()
    fun showMatch(data : List<Detail>, homeTeam : List<Team>, awayTeam: List<Team>)
}