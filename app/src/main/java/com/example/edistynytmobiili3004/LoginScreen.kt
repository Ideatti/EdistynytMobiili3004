package com.example.edistynytmobiili3004

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.edistynytmobiili3004.viewmodel.LoginViewModel

@Composable
fun LoginScreen(goToCategories: () -> Unit) {

    val loginVm: LoginViewModel = viewModel()

    Box(){
        when {
            loginVm.loginState.value.loading -> CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center))


            else -> Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = loginVm.loginState.value.username,
                    onValueChange = { newUsername ->
                        loginVm.setUsername(newUsername)
                    },
                    placeholder = {
                        Text(text = "Username")
                    })
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = loginVm.loginState.value.password,
                    onValueChange = { newPassword ->
                        loginVm.setPassword(newPassword)
                    },
                    placeholder = {
                        Text(text = "Password")
                    },
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(enabled = loginVm.loginState.value.username != "" && loginVm.loginState.value.password != "",
                    onClick = {
                        loginVm.login()
                        goToCategories()
                    }) {
                    Text(text = "Login")

                }
            }
        }
    }
}