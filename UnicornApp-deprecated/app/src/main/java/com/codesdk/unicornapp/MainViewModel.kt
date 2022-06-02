package com.codesdk.unicornapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainViewModel: ViewModel() {
    private val _loginState = MutableStateFlow<LoginUiState>(LoginUiState.Empty)
    val loginUiState: StateFlow<LoginUiState> = _loginState

    fun login(username: String, password: String) = viewModelScope.launch {
        _loginState.value = LoginUiState.Loading
        delay(2000L)
        if (username == "android" && password == "secretpassword") {
            _loginState.value = LoginUiState.Success
        } else {
            _loginState.value = LoginUiState.Error("Wrong credentials")
        }
    }

    sealed class LoginUiState {
        object Success: LoginUiState()
        data class Error(val message: String): LoginUiState()
        object Loading: LoginUiState()
        object Empty: LoginUiState()
    }
}