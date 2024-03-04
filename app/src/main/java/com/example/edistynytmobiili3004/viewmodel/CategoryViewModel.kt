package com.example.edistynytmobiili3004.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.edistynytmobiili3004.model.CategoryState

class CategoryViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    val categoryId = savedStateHandle.get<String>("categoryId")?.toIntOrNull() ?: 0


    private val _categoryState = mutableStateOf(CategoryState())
    val categoryState: State<CategoryState> = _categoryState

    init {
        Log.d("tomi", "$categoryId")
    }

}