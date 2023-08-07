package teka.android.customauth.data.remote.authentication

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import teka.android.customauth.data.remote.retrofit.AuthService
import teka.android.customauth.data.remote.retrofit.models.LoginRequest

class AuthManager(private val authService: AuthService, private val preferences: SharedPreferences) {

    suspend fun login(username: String, password: String): Boolean {
        val response = authService.login(LoginRequest(username, password))
        if (response.isSuccessful) {
            val token = response.result.access_token
            if (token != null) {
                saveAuthToken(token)
                return true
            }
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
