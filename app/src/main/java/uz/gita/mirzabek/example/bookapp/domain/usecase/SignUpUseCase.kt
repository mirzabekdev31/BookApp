package uz.gita.mirzabek.example.bookapp.domain.usecase

import kotlinx.coroutines.flow.Flow


interface SignUpUseCase {
    fun register(phone:String,password:String,lastName:String,firstName:String): Flow<Unit>
}