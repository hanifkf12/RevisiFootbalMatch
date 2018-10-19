package com.hanifkf.revisifootbalmatch.Response

import com.google.gson.annotations.SerializedName
import com.hanifkf.revisifootbalmatch.Model.Score

data class ScoreResponse( @field:SerializedName("events")
                          val events :List<Score>? =null,

                          @field:SerializedName("event")
                          val event :List<Score>? =null)