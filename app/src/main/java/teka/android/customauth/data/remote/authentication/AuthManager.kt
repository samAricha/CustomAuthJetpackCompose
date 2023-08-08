package teka.android.customauth.data.remote.authentication

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import teka.android.customauth.data.remote.retrofit.AuthService
import teka.android.customauth.data.remote.retrofit.models.LoginRequest
import teka.android.customauth.data.remote.retrofit.models.RegisterRequest

class AuthManager(private val authService: AuthService, private val preferences: SharedPreferences) {

    suspend fun login(email: String, password: String): Boolean {
        val response = authService.login(LoginRequest(email, password))
        if (response.isSuccessful) {
            val token = response.data.accessToken
            saveAuthToken(token)
            return true
        }
        return false
    }

    suspend fun register(name: String, email: String, password: String, passwordConfirmation: String): Boolean {
        val response = authService.registration(RegisterRequest(name, email, password, passwordConfirmation))
        if (response.isSuccessful) {
            val token = response.data.accessToken
            saveAuthToken(token)
            return true
        }
        return false
    }

    private suspend fun saveAuthToken(token: String) = withContext(Dispatchers.IO) {
        preferences.edit().putString("auth_token", token).apply()
    }

    fun getAuthToken(): String? {
        return preferences.getString("auth_token", null)
    }

    fun clearAuthToken() {
        preferences.edit().remove("auth_token").apply()
    }
}
