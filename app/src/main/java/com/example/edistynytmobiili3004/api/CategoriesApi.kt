package com.example.edistynytmobiili3004.api

import com.example.edistynytmobiili3004.model.AddCategoryReq
import com.example.edistynytmobiili3004.model.CategoriesResponse
import com.example.edistynytmobiili3004.model.CategoryItem
import com.example.edistynytmobiili3004.model.CategoryResponse
import com.example.edistynytmobiili3004.model.EditCategoryReq
import com.example.edistynytmobiili3004.model.Post
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

private val retrofit = createClient()

val categoriesService = retrofit.create(CategoriesApi::class.java)

interface CategoriesApi{
    @GET("category/")
    suspend fun getCategories(): CategoriesResponse

    @GET("category/{id}")
    suspend fun getCategory(@Path("id") id:Int): CategoryResponse

    @POST("category/")
    suspend fun createCategory(@Body req: AddCategoryReq) : CategoryItem

    @DELETE("category/{id}")
    suspend fun removeCategory(@Path("id") id:Int)

    @PUT("category/{id}")
    suspend fun  editCategory(
        @Path("id") id:Int,
        @Body editCategoryReq: EditCategoryReq
    ): CategoryResponse
}