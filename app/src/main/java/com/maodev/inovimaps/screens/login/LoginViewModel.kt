package com.maodev.inovimaps.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maodev.inovimaps.model.loginRequest
import com.maodev.inovimaps.retrofit.InoviMapsRetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChanged(email: String) {
        _uiState.update { state -> state.copy(email = email) }
    }

    fun onPasswordChanged(password: String) {
        _uiState.update { state -> state.copy(password = password) }
    }

    fun loginUser() {
        val email = _uiState.value.email
        val password = _uiState.value.password
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true, message = null, loginSuccess = false) }

                val response = InoviMapsRetrofitInstance.api.login(
                    loginRequest(email = email, password = password)
                )

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        message = response.message,
                        loginSuccess = response.message.contains("éxitoso", ignoreCase = true) // 👈 Aquí marcamos éxito
                    )
                }

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        message = "Error ${e.message}",
                        loginSuccess = false
                    )
                }
            }
        }
    }

}


data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val message: String? = null,
    val loginSuccess: Boolean = false
)