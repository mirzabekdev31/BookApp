package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel

import androidx.lifecycle.LiveData

interface SplashViewModel {
    val openLoginScreenLiveData: LiveData<Unit>
    val openContactScreenLiveData: LiveData<Unit>
}