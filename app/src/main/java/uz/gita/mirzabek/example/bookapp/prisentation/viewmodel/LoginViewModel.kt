package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel

import androidx.lifecycle.LiveData

interface LoginViewModel {
    val openRegesterScreenLiveData: LiveData<Unit>
    val openVerifyLoginScreenLiveData: LiveData<Unit>
    val notConnectionLiveData: LiveData<Unit>
    val progressLiveData: LiveData<Boolean>
    fun openSignUpScreenLiveData()
    fun login(phone:String,password:String)
}