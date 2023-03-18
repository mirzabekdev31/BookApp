package uz.gita.mirzabek.example.bookapp.domain.repository

interface VerifyLoginRepository {
    suspend fun verifyLogin(code:String)
}