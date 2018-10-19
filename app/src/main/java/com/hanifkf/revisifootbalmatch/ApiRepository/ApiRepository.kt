package com.hanifkf.revisifootbalmatch.ApiRepository

import android.util.Log
import java.net.URL


class ApiRepository {

    fun doRequest(url:String ): String {
        Log.d("Ini Response : ", URL(url).readText())
        return URL(url).readText()
    }
}