package teka.android.customauth.data.remote.retrofit

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import teka.android.customauth.data.remote.retrofit.models.AuthResponse
import teka.android.customauth.data.remote.retrofit.models.LoginRequest
import teka.android.customauth.data.remote.retrofit.models.Person
import teka.android.customauth.data.remote.retrofit.models.PersonInfoRequest
import teka.android.customauth.data.remote.retrofit.models.RegisterRequest

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
    ): Person
}