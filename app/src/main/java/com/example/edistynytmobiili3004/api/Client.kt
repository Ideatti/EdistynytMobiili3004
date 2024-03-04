package com.example.edistynytmobiili3004.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createClient(): Retrofit{
    return Retrofit.Builder().baseUrl("http://10.0.2.2:8000/api/v1/")
        .addConverterFactory(GsonConverterFactory.create()).build()
}