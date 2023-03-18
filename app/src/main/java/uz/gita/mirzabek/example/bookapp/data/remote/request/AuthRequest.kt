package uz.gita.mirzabek.example.bookapp.data.remote.request

data class AuthRequest (
        val phone:String,
        val password:String,
        val lastName:String,
        val firstName:String,
)