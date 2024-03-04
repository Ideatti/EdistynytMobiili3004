package com.example.edistynytmobiili3004.api

import com.example.edistynytmobiili3004.model.Post
import retrofit2.http.GET

private val retrofit = createClient()

val postsService = retrofit.create(PostsApi::class.java)

interface PostsApi{
    // baseurl + posts
    @GET("posts")
    suspend fun getPosts(): List<Post>
}