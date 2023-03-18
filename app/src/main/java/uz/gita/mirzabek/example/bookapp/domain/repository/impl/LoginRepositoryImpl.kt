package uz.gita.mirzabek.example.bookapp.domain.repository.impl

import uz.gita.mirzabek.example.bookapp.data.local.pref.AppPreferences
import uz.gita.mirzabek.example.bookapp.data.remote.api.BookApi
import uz.gita.mirzabek.example.bookapp.data.remote.request.LoginRequest
import uz.gita.mirzabek.example.bookapp.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val authApi:BookApi,private val pref:AppPreferences) : LoginRepository{

    override suspend fun login(phone: String, password: String) {
        authApi.login(pref.token, LoginRequest(phone,password)).body()?.let {
            pref.token=it.token
            pref.startScreen="CONTACT"
        }
    }
}