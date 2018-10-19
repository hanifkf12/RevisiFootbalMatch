package com.hanifkf.revisifootbalmatch.Response

import com.google.gson.annotations.SerializedName
import com.hanifkf.revisifootbalmatch.Model.Detail
import com.hanifkf.revisifootbalmatch.Model.Score

data class DetailResponse(@field:SerializedName("events")
                          val events :List<Detail>? =null,

                          @field:SerializedName("event")
                          val event :List<Detail>? =null)