package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.mirzabek.example.bookapp.data.local.pref.AppPreferences
import uz.gita.mirzabek.example.bookapp.data.remote.api.BookApi
import uz.gita.mirzabek.example.bookapp.data.remote.response.UserBooksResponse
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.UserBooksViewModel
import javax.inject.Inject


@HiltViewModel
class UserBooksViewModelImpl @Inject constructor(private val userBooksApi:BookApi,private val pref:AppPreferences ) :UserBooksViewModel,ViewModel(){

    private val list=ArrayList<UserBooksResponse>()

    override var useBooksLiveData=MutableLiveData<List<UserBooksResponse>>()
    init {
        viewModelScope.launch{
            loadBooks()
        }
    }

    override suspend fun loadBooks() {
        val response=userBooksApi.getUserBooks("Bearer ${pref.token}",2)
        if (response.isSuccessful){
            response.body()?.let {
                list.addAll(it)
                useBooksLiveData.value=list
            }
        }

//        userBooksApi.getUserBooks("Bearer ${pref.token}",2).enqueue(object :Callback<List<UserBooksResponse>>{
//            override fun onResponse(
//                call: Call<List<UserBooksResponse>>,
//                response: Response<List<UserBooksResponse>>
//            ) {
//                if (response.isSuccessful){
//                    response.body()?.let {
//                        list.addAll(it)
//                        useBooksLiveData.value=list
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<UserBooksResponse>>, t: Throwable) {
//
//            }
//
//        })
    }
}