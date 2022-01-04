package com.codesdk.unicornapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow

@ExperimentalCoroutinesApi
class MainViewModel: ViewModel() {
    private val _loginState = MutableStateFlow<LoginUiState>(LoginUiState.Empty)

    sealed class LoginUiState {
        object Success: LoginUiState()
        data class Error(val message: String): LoginUiState()
        object Loading: LoginUiState()
        object Empty: LoginUiState()
    }
}