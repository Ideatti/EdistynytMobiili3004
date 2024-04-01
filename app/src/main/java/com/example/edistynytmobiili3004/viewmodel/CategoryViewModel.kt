package com.example.edistynytmobiili3004.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edistynytmobiili3004.api.categoriesService
import com.example.edistynytmobiili3004.model.CategoryState
import com.example.edistynytmobiili3004.model.EditCategoryReq
import kotlinx.coroutines.launch

class CategoryViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    // savedStateHandlesta saa valitun kategorian id:n
    private val _categoryId = savedStateHandle.get<String>("categoryId")?.toIntOrNull() ?: 0


    private val _categoryState = mutableStateOf(CategoryState())
    val categoryState: State<CategoryState> = _categoryState

    init {
        Log.d("tomi", "$_categoryId")
        getCategory()
    }

    fun setName(newName: String){
        val item = _categoryState.value.item.copy(name=newName)
        _categoryState.value = _categoryState.value.copy(item = item)
    }


    fun editCategory(goToCategories: () -> Unit){
        viewModelScope.launch {
            try {
                _categoryState.value = _categoryState.value.copy(loading = true)
                categoriesService.editCategory(
                    _categoryId,
                    EditCategoryReq(name = _categoryState.value.item.name)
                )
                goToCategories()
                Log.d("tomi","done")
            } catch (e: Exception) {
                _categoryState.value = _categoryState.value.copy(err= e.toString())
            } finally {
                _categoryState.value = _categoryState.value.copy(loading = false)
            }
        }
    }

    private fun getCategory(){
        viewModelScope.launch {
           try {
               _categoryState.value = _categoryState.value.copy(loading = true)
               val res = categoriesService.getCategory(_categoryId)
               _categoryState.value = _categoryState.value.copy(item = res.category)
           } catch (e: Exception){
               _categoryState.value = _categoryState.value.copy(err= e.toString())
           } finally {
               _categoryState.value = _categoryState.value.copy(loading = false)
           }
        }
    }


}