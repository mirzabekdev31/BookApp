package uz.gita.mirzabek.example.bookapp.domain.usecase.impl

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.mirzabek.example.bookapp.data.local.pref.AppPreferences
import uz.gita.mirzabek.example.bookapp.domain.repository.LoginRepository
import uz.gita.mirzabek.example.bookapp.domain.repository.impl.LoginRepositoryImpl
import uz.gita.mirzabek.example.bookapp.domain.usecase.LoginScreenUseCase
import javax.inject.Inject


class LoginScreenUseCaseImpl @Inject constructor(val repository:LoginRepository) :LoginScreenUseCase{


    override fun login(phone: String, password: String): Flow<Unit> = flow<Unit>{
        emit(repository.login(phone,password))
    }
}