package uz.gita.mirzabek.example.bookapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.mirzabek.example.bookapp.data.local.room.AppDatabase
import uz.gita.mirzabek.example.bookapp.data.local.room.daos.BooksDao
import uz.gita.mirzabek.example.bookapp.data.local.room.entities.AddBookEntity
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @[Provides Singleton]
    fun getDatabase(@ApplicationContext context: Context):AppDatabase=
        Room.databaseBuilder(context, AppDatabase::class.java, "BookApp").build()

    @[Provides Singleton]
    fun getBookDao(appDatabase: AppDatabase):BooksDao=appDatabase.getBookDao()
}