package teka.android.customauth.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import teka.android.customauth.data.remote.authentication.AuthManager

class RegisterViewModel(private val authManager: AuthManager) : ViewModel() {

    private val _isRegistered = MutableStateFlow(false)
    val isRegistered: StateFlow<Boolean> = _isRegistered

    fun register(name: String, email: String, password: String, passwordConfirmation: String) {
        viewModelScope.launch {
            val success = authManager.register(name, email, password, passwordConfirmation)
            _isRegistered.value = success
        }
    }

    // Add other necessary functions or logic related to registration
}
