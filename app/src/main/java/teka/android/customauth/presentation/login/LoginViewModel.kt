package teka.android.customauth.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import teka.android.customauth.data.remote.authentication.AuthManager

class LoginViewModel(private val authManager: AuthManager) : ViewModel() {

    private var _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val success = authManager.login(email, password)
            _isLoggedIn.value = success
        }
    }

    fun logout() {
        authManager.clearAuthToken()
        _isLoggedIn.value = false
    }
}