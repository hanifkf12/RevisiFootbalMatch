package com.hanifkf.revisifootbalmatch.ApiRepository

import android.net.Uri
import com.hanifkf.revisifootbalmatch.BuildConfig

object TheSportDBApi {
    fun getNext() : String {
        //return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}"+"/search_all_teams.php?l="+league

        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("eventsnextleague.php")
            .appendQueryParameter("id","4328")
            .build()
            .toString()
    }

    fun getPrev():String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("eventspastleague.php")
            .appendQueryParameter("id","4328")
            .build()
            .toString()
    }

    fun getDetail(idEvent : String?) : String {
        //return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}"+"/search_all_teams.php?l="+league

        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("lookupevent.php")
            .appendQueryParameter("id",idEvent)
            .build()
            .toString()
    }

    fun getTeamDetail(teamId: String?):String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("lookupteam.php")
            .appendQueryParameter("id",teamId)
            .build()
            .toString()
    }

    fun getNextUrl(): String{
        return "https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4328"
    }
}