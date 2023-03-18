package uz.gita.mirzabek.example.bookapp.data.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "booksEntity")
class AddBookEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title:String,
    val author:String,
    val description:String,
    val pageCount:Int,
    val fav:Boolean
        )