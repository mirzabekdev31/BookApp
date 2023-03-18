package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.mirzabek.example.bookapp.data.remote.response.UserBooksResponse
import uz.gita.mirzabek.example.bookapp.data.remote.response.UserResponse

interface UserBooksViewModel {
    val useBooksLiveData: LiveData<List<UserBooksResponse>>

    suspend fun loadBooks()
}