package uz.gita.mirzabek.example.bookapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewComponent
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.mirzabek.example.bookapp.domain.usecase.*
import uz.gita.mirzabek.example.bookapp.domain.usecase.impl.*


@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun getBookScreenUseCase(impl:BookScreenUseCaseImpl):BookScreenUseCase

    @Binds
    fun signUpUseCase(impl:SignUpUseCaseImpl): SignUpUseCase

    @Binds
    fun splashUseCase(impl:SplashUseCaseImpl):SplashUseCase

    @Binds
    fun verifyLoginUseCase(impl:VerifyLoginUseCaseImpl):VerifyLoginUseCase

    @Binds
    fun getLoginUseCase(impl:LoginScreenUseCaseImpl):LoginScreenUseCase
}