package uz.gita.mirzabek.example.bookapp.data.remote.response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserResponse (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val lastName:String,
    val firstName:String
    )