package com.mobility.myapplication.network

import com.mobility.myapplication.model.Example
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * Created By J7202687 On 10/22/2019
 */

interface ServiceInterface {


    @GET("api/")
    fun getFriendRequestsList(@Query("results") results: String): Call<Example>

}