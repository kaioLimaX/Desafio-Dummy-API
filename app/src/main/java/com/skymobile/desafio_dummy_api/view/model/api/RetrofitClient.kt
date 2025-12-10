package com.skymobile.desafio_dummy_api.view.model.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {


    private val client = OkHttpClient.Builder()
        .build()

    val instance: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}