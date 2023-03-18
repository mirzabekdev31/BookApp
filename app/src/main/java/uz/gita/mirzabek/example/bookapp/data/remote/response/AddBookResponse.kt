package uz.gita.mirzabek.example.bookapp.data.remote.response

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "books")
data class AddBookResponse (
        @PrimaryKey(autoGenerate = true)
        val id:Int=0,
        val title:String,
        val author:String,
        val description:String,
        val pageCount:Int,
        val fav:Boolean
        )

