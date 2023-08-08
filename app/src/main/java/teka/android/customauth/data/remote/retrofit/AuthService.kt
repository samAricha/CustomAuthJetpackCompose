package teka.android.customauth.data.remote.retrofit

import retrofit2.http.Body
import retrofit2.http.POST
import teka.android.customauth.data.remote.retrofit.models.AuthResponse
import teka.android.customauth.data.remote.retrofit.models.LoginRequest
import teka.android.customauth.data.remote.retrofit.models.PersonInfoRequest
import teka.android.customauth.data.remote.retrofit.models.RegisterRequest
import teka.android.customauth.data.remote.retrofit.models.User

interface AuthService {

    @POST("registration")
    suspend fun registration(
        @Body registerRequest: RegisterRequest
    ): AuthResponse

    @POST("login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): AuthResponse

    @POST("me")
    suspend fun getMeInfo(
        @Body personInfoRequest: PersonInfoRequest
    ): User
}