package com.mobility.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created By JISHAN ANSARI On 10/26/2019
 */

data class ResultList(
    @SerializedName("results")
    @Expose
    var results: List<Results>? = null
)