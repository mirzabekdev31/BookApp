package uz.gita.mirzabek.example.bookapp.domain.usecase.impl

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.mirzabek.example.bookapp.domain.repository.VerifyLoginRepository
import uz.gita.mirzabek.example.bookapp.domain.repository.impl.BookScreenRepositoryImpl
import uz.gita.mirzabek.example.bookapp.domain.repository.impl.VerifyLoginRepositoryImpl
import uz.gita.mirzabek.example.bookapp.domain.usecase.VerifyLoginUseCase
import javax.inject.Inject


class VerifyLoginUseCaseImpl @Inject constructor(private val repository:VerifyLoginRepository) :VerifyLoginUseCase{

    override  fun verifyLogin(code: String): Flow<Unit> = flow<Unit> {
        emit(repository.verifyLogin(code))
    }
}