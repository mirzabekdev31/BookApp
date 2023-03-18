package uz.gita.mirzabek.example.bookapp.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.mirzabek.example.bookapp.domain.repository.SignUpRepository
import uz.gita.mirzabek.example.bookapp.domain.repository.impl.SignUpScreenRepositoryImpl
import uz.gita.mirzabek.example.bookapp.domain.usecase.SignUpUseCase
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor( private val repository:SignUpRepository) :SignUpUseCase{

    override fun register(
        phone: String,
        password: String,
        lastName: String,
        firstName: String
    ): Flow<Unit> = flow{
        emit(repository.register(phone,password,lastName,firstName))
    }
}