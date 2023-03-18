package uz.gita.mirzabek.example.bookapp.domain.repository.impl

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.bookappauth.utils.ConnectionUtil
import uz.gita.mirzabek.example.bookapp.data.local.pref.AppPreferences
import uz.gita.mirzabek.example.bookapp.data.local.room.AppDatabase
import uz.gita.mirzabek.example.bookapp.data.local.room.entities.AddBookEntity
import uz.gita.mirzabek.example.bookapp.data.remote.api.BookApi
import uz.gita.mirzabek.example.bookapp.data.remote.request.AddBookRequest
import uz.gita.mirzabek.example.bookapp.data.remote.request.DeleteBookRequest
import uz.gita.mirzabek.example.bookapp.data.remote.request.UpdateBookRequest
import uz.gita.mirzabek.example.bookapp.data.remote.response.AddBookResponse
import uz.gita.mirzabek.example.bookapp.data.repository.BookScreenRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookScreenRepositoryImpl @Inject constructor(
    private val authApi:BookApi,
    private val pref:AppPreferences,
    private val database:AppDatabase,
    private val connectionUtil: ConnectionUtil
    ): BookScreenRepository {
//    private val authApi = ApiClient.retrofit.create(BookApi::class.java)
//    private val pref = AppPreferences.getInstance()
    private val booksData = ArrayList<AddBookResponse>()
//    private val database=AppDatabase.getInstance()

//    companion object {
//        private lateinit var instance: BookScreenRepositoryImpl
//
//        fun init(context: Context) {
//            val api=ApiClient.retrofit.create(BookApi::class.java)
//            instance = BookScreenRepositoryImpl(api,AppPreferences.getInstance(),AppDatabase.getInstance())
//        }
//
//        fun getInstance(): BookScreenRepositoryImpl = instance
//    }


    override fun getAllBooks(): Flow<List<AddBookResponse>> = flow{
        val response=authApi.getBook("Bearer ${pref.token}")

        if(!connectionUtil.isConnected()){
            database.getBookDao().getBooks().collect{
                emit(it.map { AddBookResponse(it.id,it.title,it.author,it.description,it.pageCount,it.fav) })
            }
            Log.d("TTT","Hello Database===========================================================================================================")
            println("Hello Database====================================================================================================================================================")
        }
        response.body()?.let {
            database.getBookDao().insertAll(it.map { AddBookEntity(it.id,it.title,it.author,it.description,it.pageCount,it.fav) })
            database.getBookDao().getBooks().collect{
                emit(it.map { AddBookResponse(it.id,it.title,it.author,it.description,it.pageCount,it.fav) })
            }
        }
//        if (!isConnected()){
//            database.getBookDao().getBooks().collect{
//                it.forEach {
//                    AddBookResponse(
//                        it.id,
//                        it.title,
//                        it.author,
//                        it.description,
//                        it.pageCount,
//                        it.fav
//                    )
//                }
//                emit(it)
//            }
//
//        }
//        if (response.isSuccessful) {
//            response.body()?.let {
//               // database.getBookDao().insertAll(it)
//            }
//        }
//        database.getBookDao().getBooks().collect{
//            emit(it)
//        }

       // val liveData = MutableLiveData<Result<List<AddBookResponse>>>()
       // emit(Result.success(response.body()))




//        authApi.getBook("Bearer ${pref.token}").enqueue(object :Callback<List<AddBookResponse>>{
//            override fun onResponse(
//                call: Call<List<AddBookResponse>>,
//                response: Response<List<AddBookResponse>>
//            ) {
//                val ls: List<AddBookResponse>? = response.body()
//                if(response.isSuccessful){
//                    booksData.addAll(ls!!)
//                    liveData.value=Result.success(booksData)
//                    database.getBookDao().getBooks()
//                }else{
//                    val errorMessage=showApiError(response)
//                    liveData.value=Result.failure(Exception(errorMessage))
//                }
//
//            }
//
//            override fun onFailure(call: Call<List<AddBookResponse>>, t: Throwable) {
//                liveData.value = Result.failure(t)
//            }
//
//        })
//        return liveData
    }


//    override suspend fun deleteBook(bookId: Int) : Flow<Result<List<AddBookResponse>>> {
////        val liveData = MutableLiveData<Result<List<AddBookResponse>>>()
////        val data= DeleteBookRequest(bookId)
////        authApi.deleteBook("Bearer ${pref.token}",data).enqueue(object :Callback<DeleteBookResponse>{
////            override fun onResponse(call: Call<DeleteBookResponse>, response: Response<DeleteBookResponse>) {
////                if (response.isSuccessful){
////                    response.body()?.let {
////                        booksData.forEach {
////                            if (it.id==bookId){
////                                booksData.remove(it)
////                            }
////                            liveData.value=Result.success(booksData)
////                        }
////                    }
////                }
////            }
////
////            override fun onFailure(call: Call<DeleteBookResponse>, t: Throwable) {
////
////            }
////
////        })
////        return liveData
//    }

//    override suspend fun updateBook(data: UpdateBookRequest):Flow<List<AddBookResponse>> {
////        val liveData = MutableLiveData<Result<List<AddBookResponse>>>()
////       // authApi.updateBook(pref.token,data).enqueue(object :Callback<>)
////        return liveData
//    }


    /*
      override suspend fun add(contactRequest: ContactRequest) {

        try {
            val response = contactApi.addContact(contactRequest)
            when (response.code()) {
                in 200..299 -> {
                    val data = response.body() ?: return
                    contactDao.insert(data.toEntity())
                }
                else -> {
                    Log.d("TTT", " Something ....")
                }
            }
        } catch (e: Exception) {
            Log.d("TTT", " exception ${e.message} ....")
        }

    }
     */

    override suspend fun addBookS(title: String, author: String, description: String, pageCount: Int) {
//        if(!isConnected()){
//            database.getBookDao().insert(AddBookEntity(title = title, author = author, description = description, pageCount = pageCount, fav = false))
//        }
        if(connectionUtil.isConnected()){
            val response=authApi.addBook("Bearer ${pref.token}", AddBookRequest(title, author, description, pageCount))
            if (response.isSuccessful){
                response.body()?.let {
                    database.getBookDao().insert(AddBookEntity(it.id,it.title,it.author,it.description,it.pageCount,it.fav))
                }
            }
        }else{
            database.getBookDao().insert(AddBookEntity(title = title, author = author, description = description, pageCount = pageCount, fav = false))
        }

//
//        database.getBookDao().insert(data!!)
//        booksData.add(data!!)

//        try {
//            val response = authApi.addBook(
//                "Bearer ${pref.token}",
//                AddBookRequest(title, author, description, pageCount)
//            )
//
//            when (response.code()) {
//                in 200..299 -> {
//                    val data = response.body() ?: return
//                    database.getBookDao().insert(data)
//                }
//                else -> {
//                    Log.d("TTT", " Something ....")
//                }
//            }
//        }catch (e:Exception){
//            Log.d("TTT","${e.message}")
//        }
     }

    override suspend fun deleteBook(delete: DeleteBookRequest) {
        if (connectionUtil.isConnected()){
            val response=authApi.deleteBook("Bearer ${pref.token}",delete)
            if (response.isSuccessful){
                database.getBookDao().getBooks().collect{
                    it.forEach {
                        if (it.id==delete.bookId){
                            database.getBookDao().delete(it)
                        }
                    }
                }
            }else{
                database.getBookDao().getBooks().collect{
                    it.forEach {
                        if (it.id==delete.bookId){
                            database.getBookDao().delete(it)
                        }
                    }
                }
            }
        }else{
            database.getBookDao().getBooks().collect{
                it.forEach {
                    if (it.id==delete.bookId){
                        database.getBookDao().delete(it)
                    }
                }
            }
        }

    }

    override fun getAllLocal(): Flow<List<AddBookEntity>> = flow{
        database.getBookDao().getBooks().collect{
            emit(it)
        }
    }

    override suspend fun updateBook(update: UpdateBookRequest) {
        val request=authApi.updateBook("Bearer ${pref.token}",update)
        if (request.isSuccessful){
            database.getBookDao().update(AddBookEntity(update.id,update.title,update.author,update.description,update.pageCount,false))
        }
    }

    override suspend fun snsLocal() {
        if (connectionUtil.isConnected()){
            val response=authApi.getBook("Bearer ${pref.token}")
            if (response.isSuccessful){
                database.getBookDao().getBooks().collect{ list1->
                    response.body()?.let { list2->
                        list1.forEach { local->
                            list2.forEach { remote->
                                if (local.id!=remote.id){
                                    authApi.addBook(pref.token,AddBookRequest(local.title,local.author,local.description,local.pageCount))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
//        database.getBookDao().insert(
//            AddBookResponse(
//            title = title,
//            author = author,
//            description = description,
//            pageCount = pageCount,
//            fav = true,
//        )
//        )
//        val liveData = MutableLiveData<Result<List<AddBookResponse>>>()
//        val liveDataNotConnected = MutableLiveData<Result<List<AddBookResponse>>>()
//        authApi.addBook(
//            "Bearer ${pref.token}",
//            AddBookRequest(title,author,description,pageCount)
//        )
//            .enqueue(object :Callback<AddBookResponse>{
//                override fun onResponse(
//                    call: Call<AddBookResponse>,
//                    response: Response<AddBookResponse>
//                ) {
//                    if (response.isSuccessful){
//                        val bookData=response.body()
//                        booksData.add(bookData!!)
//                        liveData.value=Result.success(booksData)
//                    }else{
//                        val errorMessage = showApiError(response)
//                        liveData.value = Result.failure(Exception(errorMessage))
//                    }
//                }
//
//                override fun onFailure(call: Call<AddBookResponse>, t: Throwable) {
//                    liveData.value=Result.failure(t)
//                }
//
//            })
//        return liveData
//    }