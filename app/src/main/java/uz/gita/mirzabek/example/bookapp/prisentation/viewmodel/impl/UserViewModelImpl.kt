package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.mirzabek.example.bookapp.data.local.pref.AppPreferences
import uz.gita.mirzabek.example.bookapp.data.remote.api.BookApi
import uz.gita.mirzabek.example.bookapp.data.remote.response.UserResponse
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.UserViewModel
import javax.inject.Inject


@HiltViewModel
class UserViewModelImpl @Inject constructor(private val userApi :BookApi,private val pref:AppPreferences) :UserViewModel,ViewModel(){

    private val list=ArrayList<UserResponse>()


    override val backLiveData=MutableLiveData<Unit>()
    override val useLiveData=MutableLiveData<List<UserResponse>>()
    override val openUserBooksScreenLiveData=MutableLiveData<Unit>()


    override fun back() {
        backLiveData.value=Unit
    }

    init {
        loadUsers()
    }

    override fun loadUsers() {
        viewModelScope.launch {
            val response=userApi.getAllUsers("Bearer ${pref.token}")
            if (response.isSuccessful){
                response.body()?.let {
                    list.addAll(it)
                    useLiveData.value=list

                }
            }
        }


//        userApi.getAllUsers("Bearer ${pref.token}").enqueue(object :Callback<List<UserResponse>>{
//            override fun onResponse(
//                call: Call<List<UserResponse>>,
//                response: Response<List<UserResponse>>
//            ) {
//                if (response.isSuccessful){
//                    response.body()?.let {
//                        list.addAll(it)
//                        useLiveData.value=list
//
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
//
//            }
//
//        })
    }

    override fun openUserBooksScreen() {
        openUserBooksScreenLiveData.value=Unit
    }
}