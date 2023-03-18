package uz.gita.mirzabek.example.bookapp.domain.usecase.impl

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.mirzabek.example.bookapp.domain.repository.SplashRepository
import uz.gita.mirzabek.example.bookapp.domain.repository.impl.SplashRepositoryImpl
import uz.gita.mirzabek.example.bookapp.domain.usecase.SplashUseCase
import javax.inject.Inject

class SplashUseCaseImpl @Inject constructor(private val repository:SplashRepository) :SplashUseCase{

    override fun openScreen(): Flow<Int> = flow{
        if (repository.openScreen()=="LOGIN"){
            emit(1)
        }else{
            emit(2)
        }
    }
}