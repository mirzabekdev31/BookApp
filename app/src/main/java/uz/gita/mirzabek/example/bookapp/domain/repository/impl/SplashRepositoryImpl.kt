package uz.gita.mirzabek.example.bookapp.domain.repository.impl

import android.content.Context
import kotlinx.coroutines.delay
import uz.gita.mirzabek.example.bookapp.data.local.pref.AppPreferences
import uz.gita.mirzabek.example.bookapp.domain.repository.SplashRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.suspendCoroutine

@Singleton
class SplashRepositoryImpl @Inject constructor(private val pref:AppPreferences) :SplashRepository{

    override suspend fun openScreen() :String{
        if (pref.startScreen=="LOGIN"){
            return "LOGIN"
        }else{
            return "Contact"
        }
    }
}