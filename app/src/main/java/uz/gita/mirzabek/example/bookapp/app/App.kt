package uz.gita.mirzabek.example.bookapp.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import uz.gita.mirzabek.example.bookapp.data.local.pref.AppPreferences
import uz.gita.mirzabek.example.bookapp.data.local.room.AppDatabase
import uz.gita.mirzabek.example.bookapp.domain.repository.impl.BookScreenRepositoryImpl
import uz.gita.mirzabek.example.bookapp.domain.repository.impl.SplashRepositoryImpl
import uz.gita.mirzabek.example.bookapp.domain.repository.impl.VerifyLoginRepositoryImpl
import uz.gita.mirzabek.example.bookapp.domain.usecase.impl.BookScreenUseCaseImpl
import uz.gita.mirzabek.example.bookapp.domain.usecase.impl.LoginScreenUseCaseImpl
import uz.gita.mirzabek.example.bookapp.domain.usecase.impl.SplashUseCaseImpl
import uz.gita.mirzabek.example.bookapp.domain.usecase.impl.VerifyLoginUseCaseImpl

@HiltAndroidApp
class App :Application()