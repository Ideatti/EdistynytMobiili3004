package com.example.edistynytmobiili3004.model

import com.google.gson.annotations.SerializedName

data class CategoriesState(
    val list: List<CategoryItem> = emptyList(),
    val loading: Boolean = false,
    val err: String? = null
)

data class CategoryState(
    val item: CategoryItem = CategoryItem(),
    val loading: Boolean = false,
    val err: String? = null
)

data class CategoryItem(
    @SerializedName("category_id")
    val id: Int = 0,
    @SerializedName("category_name")
    val name: String = "")

data class CategoriesResponse(val categories: List<CategoryItem> = emptyList())
