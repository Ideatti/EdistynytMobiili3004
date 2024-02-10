package com.example.edistynytmobiili3004.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edistynytmobiili3004.model.LoginReqModel
import com.example.edistynytmobiili3004.model.LoginResModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginState = mutableStateOf(LoginReqModel())
    val loginState: State<LoginReqModel> = _loginState

    fun setUsername(newUsername: String){
        _loginState.value = _loginState.value.copy(username = newUsername)
    }

    fun setPassword(newPassword: String){
        _loginState.value = _loginState.value.copy(password = newPassword)
    }

    private suspend fun _waitForLogin(){
        delay(2000)
    }

    fun login(){

        viewModelScope.launch {
            _loginState.value = _loginState.value.copy(loading = true)
            _waitForLogin()
            val user = LoginResModel()
            _loginState.value = _loginState.value.copy(loading = false)
        }
    }
}