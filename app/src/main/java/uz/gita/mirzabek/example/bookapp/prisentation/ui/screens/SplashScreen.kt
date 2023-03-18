package uz.gita.mirzabek.example.bookapp.prisentation.ui.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.mirzabek.example.bookapp.R
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl.SplashViewModelImpl

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen :Fragment(R.layout.screen_splash){
    private val viewmodel by viewModels<SplashViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.openContactScreenLiveData.observe(viewLifecycleOwner,openContactScreenLiveDataObser)
        viewmodel.openLoginScreenLiveData.observe(viewLifecycleOwner,openLoginScreenLiveDataObser)
    }

    val openContactScreenLiveDataObser=Observer<Unit>{
        findNavController().navigate(R.id.action_splashScreen_to_bookScreen)
    }

    val openLoginScreenLiveDataObser=Observer<Unit>{
        findNavController().navigate(R.id.action_splashScreen_to_loginScreen)
    }
}