package com.mobility.myapplication.network

import com.mobility.myapplication.model.ResultList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * Created By JISHAN ANSARI On 10/26/2019
 */

interface ServiceInterface {
    @GET("api/")
    fun getFriendRequestsList(@Query("results") results: String): Call<ResultList>
}