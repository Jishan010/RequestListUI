package com.mobility.myapplication.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 * Created By JISHAN ANSARI On 10/26/2019
 */

object ServiceBuilder {
    // Create Retrofit Instance
    private var retrofit: Retrofit? = null

    private var serviceInterface: ServiceInterface? = null


    //for log
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    // Create OkHttp Client
    private val okHttp = OkHttpClient.Builder().callTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(logger)
    private const val BASE_URL = "https://randomuser.me/"

    fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp.build()).build()
        } else
            retrofit;

        return retrofit;
    }


    fun getSerice() : ServiceInterface {
        serviceInterface = retrofit!!.create(ServiceInterface::class.java)

        return  serviceInterface!!
    }

}