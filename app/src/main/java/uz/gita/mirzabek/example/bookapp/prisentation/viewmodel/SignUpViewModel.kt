package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel

import androidx.lifecycle.LiveData

interface SignUpViewModel {
    val openVerifyScreenLiveData: LiveData<Unit>
    val progressLiveData: LiveData<Boolean>

    fun register(phone:String,password:String,lastName:String,firstName:String)

    /*
     phone  : String,
    - password : String,
    - lastName:String,
    - firstName:String
     */
}