package eu.tutorials.propertyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

sealed class AuthState {
    object Authenticated : AuthState()
    data class Error(val message: String?) : AuthState()
    object Loading : AuthState()
    object Unauthenticated : AuthState()
}

class AuthViewModel : ViewModel() {
    private val _authState = MutableLiveData<AuthState>(AuthState.Unauthenticated)
    val authState: LiveData<AuthState> get() = _authState

    fun login(email: String, password: String) {
        // Implement your login logic here (e.g., using Firebase Authentication)
        // For simplicity, we'll just simulate a successful login
        _authState.value = AuthState.Loading
        if (email == "test@example.com" && password == "password") {
            _authState.value = AuthState.Authenticated
        } else {
            _authState.value = AuthState.Error("Invalid email or password")
        }
    }

    fun signup(email: String, password: String, firstname: String, lastname: String) {
        // Implement your signup logic here (e.g., using Firebase Authentication)
        // For simplicity, we'll just simulate a successful signup
        _authState.value = AuthState.Loading
        if (email.isNotEmpty() && password.isNotEmpty()) {
            _authState.value = AuthState.Authenticated
        } else {
            _authState.value = AuthState.Error("Invalid signup details")
        }
    }

    fun signout() {
        _authState.value = AuthState.Unauthenticated
    }
}
