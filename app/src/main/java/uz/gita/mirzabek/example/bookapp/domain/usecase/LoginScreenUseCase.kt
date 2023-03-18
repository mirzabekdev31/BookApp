package uz.gita.mirzabek.example.bookapp.domain.usecase

import kotlinx.coroutines.flow.Flow


interface LoginScreenUseCase {
    fun login(phone:String,password:String): Flow<Unit>
}