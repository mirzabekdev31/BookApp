package uz.gita.mirzabek.example.bookapp.domain.repository.impl

import uz.gita.mirzabek.example.bookapp.data.local.pref.AppPreferences
import uz.gita.mirzabek.example.bookapp.data.remote.api.BookApi
import uz.gita.mirzabek.example.bookapp.data.remote.request.AuthRequest
import uz.gita.mirzabek.example.bookapp.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpScreenRepositoryImpl @Inject constructor(private val authApi:BookApi,private val pref:AppPreferences) :SignUpRepository{

    override suspend fun register(
        phone: String,
        password: String,
        lastName: String,
        firstName: String
    ) {
        val response=authApi.register(AuthRequest(phone,password,firstName,lastName))
        if (response.isSuccessful){
            if (response.isSuccessful){
                response.body()?.let {
                    pref.token=it.token
                    pref.startScreen="CONTACT"
                }
            }
        }
    }
}