package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.gita.mirzabek.example.bookapp.data.local.room.entities.AddBookEntity
import uz.gita.mirzabek.example.bookapp.data.remote.request.DeleteBookRequest
import uz.gita.mirzabek.example.bookapp.data.remote.request.UpdateBookRequest
import uz.gita.mirzabek.example.bookapp.data.remote.response.AddBookResponse
import uz.gita.mirzabek.example.bookapp.data.remote.response.DeleteBookResponse
import uz.gita.mirzabek.example.bookapp.data.repository.BookScreenRepository
import uz.gita.mirzabek.example.bookapp.domain.repository.impl.BookScreenRepositoryImpl
import uz.gita.mirzabek.example.bookapp.domain.usecase.BookScreenUseCase
import uz.gita.mirzabek.example.bookapp.domain.usecase.impl.BookScreenUseCaseImpl
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.BookScreenViewModel
import javax.inject.Inject


@HiltViewModel
class BookScreenViewModelImpl @Inject constructor(private val bookUseCase:BookScreenUseCase) :BookScreenViewModel,ViewModel(){

//    private val authApi = ApiClient.retrofit.create(BookApi::class.java)
//    private val pref = AppPreferences.getInstance()

    //val repository= BookScreenUseCaseImpl.getInstance()
    override val bookLiveData=MutableLiveData<List<AddBookResponse>>()
    override val addBookDialogLiveData=MediatorLiveData<Unit>()

    override val openUserScreenLivedata=MutableLiveData<Unit>()
    override val messageLiveData=MutableLiveData<DeleteBookResponse>()
    override val openUpdateDialog=MutableLiveData<Unit>()

    init {
        loadBook()
    }


    override fun loadBook() {
        viewModelScope.launch(Dispatchers.IO) {
            bookUseCase?.getAllBooks()?.collect{
                bookLiveData.postValue(it)
            }

//
//            addBookDialogLiveData.addDisposable(repository.getAllBooks()){
//                it.onFailure{
//                }
//                it.onSuccess {
//                    bookLiveData.value=ArrayList(it)
//                }
//            }
        }


//        authApi.getBook("Bearer ${pref.token}").enqueue(object :Callback<List<AddBookResponse>>{
//            override fun onResponse(
//                call: Call<List<AddBookResponse>>,
//                response: Response<List<AddBookResponse>>
//            ) {
//                if (response.isSuccessful){
//                    response.body()?.let {
//                        list.addAll(it)
//                        bookLiveData.value=ArrayList(list)
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<AddBookResponse>>, t: Throwable) {
//
//            }
//
//        })
    }

    override fun openUserScreen() {
        openUserScreenLivedata.value=Unit
    }

    override fun addBookS(title: String, author: String, description: String, pageCount: Int) {
        viewModelScope.launch {
            bookUseCase?.addBookS(title,author,description, pageCount)
        }


//        viewModelScope.launch(Dispatchers.IO) {
//            repository.addBookS(title,author,description,pageCount)
//        }

//        viewModelScope.launch {
//            addBookDialogLiveData.addDisposable(repository.addBookS(title,author,description,pageCount)){
//                it.onFailure {
//
//                }
//
//                it.onSuccess {
//                    bookLiveData.value=ArrayList(it)
//                }
//            }
//        }

//        authApi.addBook(
//            "Bearer ${pref.token}",
//            AddBookRequest(title,author,description,pageCount))
//            .enqueue(object :Callback<AddBookResponse>{
//                override fun onResponse(
//                    call: Call<AddBookResponse>,
//                    response: Response<AddBookResponse>
//                ) {
//                    if (response.isSuccessful){
//                        response.body()?.let {
//                            list.add(it)
//                            bookLiveData.value=ArrayList(list)
//                            //database.getBookDao().insert(it)
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<AddBookResponse>, t: Throwable) {
//
//                }
//
//            })
    }

    override fun openAddContactDialog() {
        addBookDialogLiveData.value=Unit
    }

    override fun deleteBook(bookId:Int) {

        viewModelScope.launch {
            bookUseCase.deleteBook(DeleteBookRequest(bookId))
        }



//        viewModelScope.launch {
//            addBookDialogLiveData.addDisposable(repository.deleteBook(bookId)){
//                it.onFailure {
//
//                }
//                it.onSuccess {
//                    bookLiveData.value=it
//                }
//            }
//        }

//        authApi.deleteBook("Bearer ${pref.token}",data).enqueue(object :Callback<DeleteBookResponse>{
//            override fun onResponse(call: Call<DeleteBookResponse>, response: Response<DeleteBookResponse>) {
//                if (response.isSuccessful){
//                    response.body()?.let {
//                        list.forEach {
//                            if (it.id==bookId){
//                                list.remove(it)
//                            }
//                            bookLiveData.value=ArrayList(list)
//                        }
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<DeleteBookResponse>, t: Throwable) {
//
//            }
//
//        })
    }

    override fun updateBook(data: UpdateBookRequest) {
        viewModelScope.launch {
            bookUseCase.updateBook(data)
        }
//        authApi.updateBook(pref.token,data).enqueue(object :Callback<AddBookResponse>{
//            override fun onResponse(
//                call: Call<AddBookResponse>,
//                response: Response<AddBookResponse>
//            ) {
//                if (response.isSuccessful){
//                    response.body()?.let {
//                        for (i in 0..list.size){
//                            if (list[i].id==data.id){
//                                list.set(i,it)
//                            }
//                        }
//                    }
//
//                }
//            }
//
//            override fun onFailure(call: Call<AddBookResponse>, t: Throwable) {
//
//            }
//
//        }
//        )
    }

    override fun openUpdateDialog() {
        openUpdateDialog.value=Unit
    }
}