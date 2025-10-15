package com.maodev.inovimaps.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InoviMapsRetrofitInstance {

    private val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }).build()

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("http://localhost:3000").addConverterFactory(
            GsonConverterFactory.create()
        ).client(client).build()
    }

    val api: InoviMapApiService by lazy {
        retrofit.create(InoviMapApiService::class.java)
    }
}