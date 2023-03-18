package uz.gita.mirzabek.example.bookapp.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.gita.mirzabek.example.bookapp.data.local.room.daos.BooksDao
import uz.gita.mirzabek.example.bookapp.data.local.room.daos.UsersDao
import uz.gita.mirzabek.example.bookapp.data.local.room.entities.AddBookEntity
import uz.gita.mirzabek.example.bookapp.data.remote.response.AddBookResponse
import uz.gita.mirzabek.example.bookapp.data.remote.response.UserResponse
import javax.inject.Inject
import javax.inject.Singleton


@Database(entities = [AddBookEntity::class], version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun getBookDao():BooksDao
}