package uz.gita.mirzabek.example.bookapp.domain.repository

import kotlinx.coroutines.flow.Flow


interface LoginRepository {
    suspend fun login(phone:String,password:String)
}