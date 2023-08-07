package teka.android.customauth.data.remote.retrofit.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val isSuccessful: Boolean,
    val result: AuthResult,
    val total_pages: Int,
    val total_results: Int
)

@Serializable
data class AuthResult(
   val access_token:String,
   val token_type:String,
)


data class Person(
    val id: Int,
    val name: String,
    val email: String,
    val email_verified_at: String,
    val created_at: String,
    val updated_at: String,
)