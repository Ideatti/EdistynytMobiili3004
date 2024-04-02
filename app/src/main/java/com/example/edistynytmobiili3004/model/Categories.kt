package com.example.edistynytmobiili3004.model

import com.google.gson.annotations.SerializedName

data class CategoriesState(
    val list: List<CategoryItem> = emptyList(),
    val loading: Boolean = false,
    val err: String? = null,
    val isAddingCategory: Boolean = false
)

data class AddCategoryState(
    val loading: Boolean = false,
    val ok: Boolean = false,
    val err: String? = null,
    val name: String = ""
)

data class CategoryState(
    val item: CategoryItem = CategoryItem(),
    val loading: Boolean = false,
    val err: String? = null,
    val ok: Boolean = false
)

data class DeleteCategoryState(
    val id: Int = 0,
    val err: String? = null
)

data class CategoryItem(
    @SerializedName("category_id")
    val id: Int = 0,
    @SerializedName("category_name")
    val name: String = "")

data class CategoriesResponse(val categories: List<CategoryItem> = emptyList())
data class CategoryResponse(val category: CategoryItem = CategoryItem())
data class EditCategoryReq(
    @SerializedName("category_name")
    val name: String
)
data class AddCategoryReq(
    @SerializedName("category_name")
    val name: String
)