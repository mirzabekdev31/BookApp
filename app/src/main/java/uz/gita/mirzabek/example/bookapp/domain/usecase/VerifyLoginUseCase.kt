package uz.gita.mirzabek.example.bookapp.domain.usecase

import kotlinx.coroutines.flow.Flow


interface VerifyLoginUseCase {
    fun verifyLogin(code:String): Flow<Unit>
}