package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel

import androidx.lifecycle.LiveData

interface VerifyLoginViewModel {
    val openMainScreenLiveData:LiveData<Unit>


    fun verifyLogin(code:String)
}