package uz.gita.mirzabek.example.bookapp.domain.repository

interface SplashRepository {
    suspend fun openScreen():String
}