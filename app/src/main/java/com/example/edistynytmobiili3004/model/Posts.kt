package com.example.edistynytmobiili3004.model

data class Post(val userId: Int, val id: Int, val title: String, val body: String)

data class PostsState(val list: List<Post> = emptyList(),
                      val loading: Boolean = false,
                      val error: String? = null)
