package com.example.edistynytmobiili3004.model

data class CategoriesState(val list: List<CategoryItem> = emptyList(),
    val loading: Boolean = false)

data class CategoryItem(val category_id: Int = 0, val category_name: String = "")

data class CategoriesResponse(val categories: List<CategoryItem> = emptyList())
