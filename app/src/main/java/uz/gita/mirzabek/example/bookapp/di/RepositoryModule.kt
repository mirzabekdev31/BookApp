package uz.gita.mirzabek.example.bookapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mirzabek.example.bookapp.data.repository.BookScreenRepository
import uz.gita.mirzabek.example.bookapp.domain.repository.LoginRepository
import uz.gita.mirzabek.example.bookapp.domain.repository.SignUpRepository
import uz.gita.mirzabek.example.bookapp.domain.repository.SplashRepository
import uz.gita.mirzabek.example.bookapp.domain.repository.VerifyLoginRepository
import uz.gita.mirzabek.example.bookapp.domain.repository.impl.*


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun getBookScreenRepositoryImpl(impl:BookScreenRepositoryImpl):BookScreenRepository

    @Binds
    fun getLoginRepositoryImpl(impl:LoginRepositoryImpl):LoginRepository

    @Binds
    fun getSplashRepositoryImpl(impl: SplashRepositoryImpl):SplashRepository

    @Binds
    fun getSignUpRepositoryImpl(impl:SignUpScreenRepositoryImpl):SignUpRepository

    @Binds
    fun getVerifyLoginRepositoryImpl(impl: VerifyLoginRepositoryImpl):VerifyLoginRepository

}