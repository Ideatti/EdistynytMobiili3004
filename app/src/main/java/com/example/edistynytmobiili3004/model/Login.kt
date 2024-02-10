package com.example.edistynytmobiili3004.model

data class LoginReqModel(val username: String = "",
                         val password: String = "",
                         val loading: Boolean = false)

data class LoginResModel(
    val id: Int = 0,
    val accessToken: String = "",
    val username: String = ""
)