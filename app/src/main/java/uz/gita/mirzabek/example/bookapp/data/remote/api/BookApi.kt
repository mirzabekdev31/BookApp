package uz.gita.mirzabek.example.bookapp.data.remote.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import uz.gita.mirzabek.example.bookapp.data.remote.request.*
import uz.gita.mirzabek.example.bookapp.data.remote.response.*

interface BookApi {

    @POST("auth/sign-up")
    suspend fun register(@Body data: AuthRequest): Response<AuthResponse.RegisterResponse>

    @POST("auth/sign-up/verify")
    suspend fun verify(
        @Header("authorization") token: String,
        @Body() data: VerifyRequest
    ): Response<AuthResponse.VerifyResponse>

    @POST("auth/sign-in")
    suspend fun login(
        @Header("authorization") token: String,
        @Body data: LoginRequest
    ): Response<AuthResponse.LoginResponse>

    @POST("auth/sign-in/verify")
    suspend fun verifyLogin(
        @Header("authorization") token: String,
        @Body data: VerifyLoginRequest
    ): Response<AuthResponse.VerifyLoginResponse>

    @POST("book")
    suspend fun addBook(
        @Header("authorization") token: String,
        @Body data: AddBookRequest
    ): Response<AddBookResponse>

    @GET("books")
    suspend fun getBook(@Header("authorization") accessToken: String): Response<List<AddBookResponse>>

    @HTTP(method = "DELETE", path = "/book", hasBody = true)
    suspend fun deleteBook(
        @Header("authorization") token: String,
        @Body data: DeleteBookRequest
    ): Response<DeleteBookResponse>

    @GET("books/users")
    suspend fun getAllUsers(@Header("authorization") token: String): Response<List<UserResponse>>

    @POST("books/user")
    suspend fun getUserBooks(
        @Header("authorization") token: String,
        userId: Int
    ): Response<List<UserBooksResponse>>

    @PUT("book")
    suspend fun updateBook(
        @Header("authorization") token: String,
        data: UpdateBookRequest
    ): Response<UpdateBookResponse>

}