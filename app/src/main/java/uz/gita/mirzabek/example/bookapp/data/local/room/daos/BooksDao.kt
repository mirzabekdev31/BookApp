package uz.gita.mirzabek.example.bookapp.data.local.room.daos

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import kotlinx.coroutines.flow.Flow
import uz.gita.mirzabek.example.bookapp.data.local.room.entities.AddBookEntity
import uz.gita.mirzabek.example.bookapp.data.remote.response.AddBookResponse

@Dao
interface BooksDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(bookEnt: AddBookEntity): Long

    @Insert(onConflict = REPLACE)
    suspend fun insertAll(books: List<AddBookEntity>)

    @Delete
    suspend fun delete(bookResponse: AddBookEntity)

    @Update
    suspend fun update(bookResponse: AddBookEntity)

    @Query("SELECT * FROM booksEntity ")
    fun getBooks(): Flow<List<AddBookEntity>>

}