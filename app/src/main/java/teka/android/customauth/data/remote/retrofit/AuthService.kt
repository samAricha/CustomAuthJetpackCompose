package teka.android.customauth.data.remote.retrofit

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import teka.android.customauth.data.remote.retrofit.models.AuthResponse
import teka.android.customauth.data.remote.retrofit.models.Person

interface AuthService {

    @POST("registration")
    suspend fun getRegistrationResponse(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): AuthResponse

    @POST("login")
    suspend fun getLoginResponse(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): AuthResponse

    @POST("me")
    suspend fun getMeResponse(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Person
}