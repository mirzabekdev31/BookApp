package uz.gita.mirzabek.example.bookapp.data.repository

import androidx.lifecycle.LiveData
import androidx.room.Update
import uz.gita.mirzabek.example.bookapp.data.remote.request.UpdateBookRequest
import uz.gita.mirzabek.example.bookapp.data.remote.response.AddBookResponse
import kotlinx.coroutines.flow.Flow
import uz.gita.mirzabek.example.bookapp.data.local.room.entities.AddBookEntity
import uz.gita.mirzabek.example.bookapp.data.remote.request.DeleteBookRequest

interface BookScreenRepository {

    fun getAllBooks():Flow<List<AddBookResponse>>

   // suspend fun deleteBook(bookId:Int): Flow<Result<List<AddBookResponse>>>
   // suspend fun updateBook(data: UpdateBookRequest):Flow<List<AddBookResponse>>
    suspend fun addBookS( title:String, author:String, description:String, pageCount:Int)
    suspend fun deleteBook(delete:DeleteBookRequest)
    fun getAllLocal():Flow<List<AddBookEntity>>
    suspend fun updateBook(update: UpdateBookRequest)
    suspend fun snsLocal()
}