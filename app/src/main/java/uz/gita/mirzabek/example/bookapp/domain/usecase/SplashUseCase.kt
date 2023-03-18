package uz.gita.mirzabek.example.bookapp.domain.usecase

import kotlinx.coroutines.flow.Flow


interface SplashUseCase {
    fun openScreen(): Flow<Int>
}