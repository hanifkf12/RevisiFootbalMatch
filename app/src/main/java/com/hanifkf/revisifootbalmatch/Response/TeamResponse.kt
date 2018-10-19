package com.hanifkf.revisifootbalmatch.Response

import com.google.gson.annotations.SerializedName
import com.hanifkf.revisifootbalmatch.Model.Detail
import com.hanifkf.revisifootbalmatch.Model.Team

data class TeamResponse(@field:SerializedName("teams")
                        val teams :List<Team>? =null,

                        @field:SerializedName("team")
                        val team :List<Team>? =null)