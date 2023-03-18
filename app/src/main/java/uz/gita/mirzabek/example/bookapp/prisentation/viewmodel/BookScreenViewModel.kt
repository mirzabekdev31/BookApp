package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.mirzabek.example.bookapp.data.local.room.entities.AddBookEntity
import uz.gita.mirzabek.example.bookapp.data.remote.request.UpdateBookRequest

import uz.gita.mirzabek.example.bookapp.data.remote.response.AddBookResponse
import uz.gita.mirzabek.example.bookapp.data.remote.response.DeleteBookResponse

interface BookScreenViewModel {
    val bookLiveData:LiveData<List<AddBookResponse>>
    val addBookDialogLiveData:LiveData<Unit>
    val openUserScreenLivedata:LiveData<Unit>
    val messageLiveData:LiveData<DeleteBookResponse>
    val openUpdateDialog:LiveData<Unit>


    fun loadBook()
    fun openUserScreen()
    fun addBookS( title:String, author:String, description:String, pageCount:Int)
    fun openAddContactDialog()

    fun deleteBook(bookId:Int)
    fun updateBook(data: UpdateBookRequest)
    fun openUpdateDialog()

}