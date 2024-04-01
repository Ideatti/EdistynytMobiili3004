package com.example.edistynytmobiili3004

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.edistynytmobiili3004.viewmodel.CategoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCategoryScreen(backToCategories : () -> Unit, goToCategories: () -> Unit ){
    val vm: CategoryViewModel = viewModel()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(vm.categoryState.value.item.name) },
                navigationIcon ={ IconButton(onClick = { backToCategories() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back to categories")

                }} )

        }
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            when{
                vm.categoryState.value.loading -> CircularProgressIndicator(
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
                vm.categoryState.value.err != null -> Text("Virhe ${vm.categoryState.value.err}")
                else -> {
                    Column (modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        OutlinedTextField(
                            value = vm.categoryState.value.item.name,
                            onValueChange = {
                                vm.setName(it)
                            } )

                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { vm.editCategory(goToCategories) }) {
                            Text("Edit")

                        }
                    }
                }
            }
        }
    }

}