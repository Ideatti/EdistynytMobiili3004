package com.example.edistynytmobiili3004.api

import com.example.edistynytmobiili3004.model.CategoriesResponse
import com.example.edistynytmobiili3004.model.Post
import retrofit2.http.GET

private val retrofit = createClient()

val categoriesService = retrofit.create(CategoriesApi::class.java)

interface CategoriesApi{
    @GET("category/")
    suspend fun getCategories(): CategoriesResponse
}