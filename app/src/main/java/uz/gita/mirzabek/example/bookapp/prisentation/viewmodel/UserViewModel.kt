package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.mirzabek.example.bookapp.data.remote.response.UserResponse

interface UserViewModel {
    val backLiveData:LiveData<Unit>
    val useLiveData:LiveData<List<UserResponse>>
    val openUserBooksScreenLiveData:LiveData<Unit>


    fun back()
    fun loadUsers()
    fun openUserBooksScreen()
}