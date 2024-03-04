package com.example.edistynytmobiili3004

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.edistynytmobiili3004.viewmodel.PostsViewModel

@Composable
fun PostsScreen (){
    val postsVm: PostsViewModel = viewModel()
    LazyColumn(){
        items(postsVm.postsState.value.list){
            Text(text = it.title)
        }
    }
}