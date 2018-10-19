package com.hanifkf.revisifootbalmatch.Model

import com.google.gson.annotations.SerializedName

data class Score(

    @SerializedName("idEvent")
    val eventId: String? = null,

    @SerializedName("dateEvent")
    val eventDate: String? = null,

    @SerializedName("strHomeTeam")
    val homeTeam: String? = null,

    @SerializedName("intHomeScore")
    val homeScore: String? = null,

    @SerializedName("strAwayTeam")
    val awayTeam: String? = null,

    @SerializedName("intAwayScore")
    val awayScore: String? = null,

    @SerializedName("idHomeTeam")
    val homeTeamId: String? = null,

    @SerializedName("idAwayTeam")
    val awayTeamId: String? = null



)