package com.example.edistynytmobiili3004.api

import com.example.edistynytmobiili3004.model.CategoriesResponse
import com.example.edistynytmobiili3004.model.CategoryResponse
import com.example.edistynytmobiili3004.model.EditCategoryReq
import com.example.edistynytmobiili3004.model.Post
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

private val retrofit = createClient()

val categoriesService = retrofit.create(CategoriesApi::class.java)

interface CategoriesApi{
    @GET("category/")
    suspend fun getCategories(): CategoriesResponse

    @GET("category/{id}")
    suspend fun getCategory(@Path("id") id:Int): CategoryResponse

    @PUT("category/{id}")
    suspend fun  editCategory(
        @Path("id") id:Int,
        @Body editCategoryReq: EditCategoryReq
    ): CategoryResponse
}