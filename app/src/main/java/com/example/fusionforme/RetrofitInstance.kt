package com.example.fusionforme

import com.example.fusionforme.Service.ListExerciceService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://github.com/"
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val listExerciceService: ListExerciceService by lazy {
        retrofit.create(ListExerciceService::class.java)
    }
}