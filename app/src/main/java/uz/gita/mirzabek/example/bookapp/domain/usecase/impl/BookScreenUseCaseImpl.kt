package uz.gita.mirzabek.example.bookapp.domain.usecase.impl


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.bookappauth.utils.ConnectionUtil
import uz.gita.mirzabek.example.bookapp.data.remote.request.DeleteBookRequest
import uz.gita.mirzabek.example.bookapp.data.remote.request.UpdateBookRequest
import uz.gita.mirzabek.example.bookapp.data.remote.response.AddBookResponse
import uz.gita.mirzabek.example.bookapp.data.repository.BookScreenRepository
import uz.gita.mirzabek.example.bookapp.domain.usecase.BookScreenUseCase
import javax.inject.Inject

class BookScreenUseCaseImpl @Inject constructor(val repository: BookScreenRepository,private val connectionUtil: ConnectionUtil) : BookScreenUseCase {


    override suspend fun getAllBooks(): Flow<List<AddBookResponse>> = flow{
       if (connectionUtil.isConnected()){
           repository.getAllBooks().collect{
               emit(it)
           }
       }else{
           repository.getAllLocal().collect{
               emit(it.map { AddBookResponse(it.id,it.title,it.author,it.description,it.pageCount,it.fav) })
           }
       }
    }

    override suspend fun addBookS(
        title: String,
        author: String,
        description: String,
        pageCount: Int
    ) {
        repository.addBookS(title,author,description,pageCount)
    }

    override suspend fun deleteBook(delete: DeleteBookRequest) {
        repository.deleteBook(delete)
    }

    override suspend fun updateBook(update: UpdateBookRequest) {
        repository.updateBook(update)
    }
}