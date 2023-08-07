package teka.android.customauth.data.remote.retrofit.models

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
    )

data class LoginRequest(
    val email: String,
    val password: String
)

data class PersonInfoRequest(
    val username: String,
    val password: String
)