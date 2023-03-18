package uz.gita.mirzabek.example.bookapp.domain.repository.impl

import android.content.Context
import uz.gita.mirzabek.example.bookapp.data.local.pref.AppPreferences
import uz.gita.mirzabek.example.bookapp.data.remote.api.BookApi
import uz.gita.mirzabek.example.bookapp.data.remote.request.VerifyLoginRequest
import uz.gita.mirzabek.example.bookapp.domain.repository.VerifyLoginRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VerifyLoginRepositoryImpl @Inject constructor(
    private val authApi:BookApi,
    private val pref:AppPreferences
) :VerifyLoginRepository{

    override suspend fun verifyLogin(code: String) {
        val response=authApi.verifyLogin("Bearer ${pref.token}", VerifyLoginRequest(code))
        if(response.isSuccessful){
            response.body()?.let {
                pref.accesToken1=it.token
            }
        }
    }


}