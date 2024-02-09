package com.example.edistynytmobiili3004

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.edistynytmobiili3004.ui.theme.EdistynytMobiili3004Theme
import androidx.compose.runtime.remember as remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdistynytMobiili3004Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ) {
                    LoginScreen()
                }
            }
        }
    }
}



@Composable
fun LoginScreen() {
    val username = remember{
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = username.value, onValueChange = {newUsername ->
                      username.value = newUsername
        }, placeholder = {
            Text(text = "Username")
        })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = password.value, onValueChange = {newPassword ->
                       password.value = newPassword
        }, placeholder = {
            Text(text = "Password")
        }, visualTransformation = PasswordVisualTransformation())
    }

}

