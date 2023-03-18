package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel

import androidx.lifecycle.LiveData

interface VerifyViewModel {
    val openMainScreenLiveData:LiveData<Unit>


    fun verify(code:String)
}