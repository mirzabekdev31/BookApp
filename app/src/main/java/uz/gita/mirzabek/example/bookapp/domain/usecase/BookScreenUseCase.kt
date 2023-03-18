package uz.gita.mirzabek.example.bookapp.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.mirzabek.example.bookapp.data.local.room.entities.AddBookEntity
import uz.gita.mirzabek.example.bookapp.data.remote.request.DeleteBookRequest
import uz.gita.mirzabek.example.bookapp.data.remote.request.UpdateBookRequest
import uz.gita.mirzabek.example.bookapp.data.remote.response.AddBookResponse

interface BookScreenUseCase {

    suspend fun getAllBooks(): Flow<List<AddBookResponse>>
    suspend fun addBookS( title:String, author:String, description:String, pageCount:Int)
    suspend fun deleteBook(delete: DeleteBookRequest)
    suspend fun updateBook(update: UpdateBookRequest)
}