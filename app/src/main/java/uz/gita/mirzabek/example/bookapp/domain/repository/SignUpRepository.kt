package uz.gita.mirzabek.example.bookapp.domain.repository

interface SignUpRepository {
    suspend fun register(phone:String,password:String,lastName:String,firstName:String)
}