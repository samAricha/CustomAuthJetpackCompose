package teka.android.customauth.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import teka.android.customauth.data.remote.authentication.AuthManager

class LoginViewModel(private val authManager: AuthManager) : ViewModel() {
    var isLoggedIn: Boolean = authManager.getAuthToken() != null
        private set

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val success = authManager.login(username, password)
            isLoggedIn = success
        }
    }

    fun logout() {
        authManager.clearAuthToken()
        isLoggedIn = false
    }
}