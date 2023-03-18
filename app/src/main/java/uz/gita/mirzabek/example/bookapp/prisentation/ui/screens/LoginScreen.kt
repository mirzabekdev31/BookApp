package uz.gita.mirzabek.example.bookapp.prisentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.bookappauth.utils.myApply
import uz.gita.mirzabek.example.bookapp.R
import uz.gita.mirzabek.example.bookapp.databinding.ScreenLoginBinding
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl.LoginViewModelImpl
@AndroidEntryPoint
class LoginScreen :Fragment(R.layout.screen_login){
    private val viewModel by viewModels<LoginViewModelImpl>()
    private val binding by viewBinding(ScreenLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =binding.myApply{
        super.onViewCreated(view, savedInstanceState)

        buttonRegister.setOnClickListener { viewModel.openSignUpScreenLiveData() }
        viewModel.openRegesterScreenLiveData.observe(viewLifecycleOwner,openRegesterScreenLiveDataOser)
        buttonLogin.setOnClickListener { viewModel.login(PhoneNumber.text.toString(),inputPassword.text.toString()) }
        viewModel.openVerifyLoginScreenLiveData.observe(viewLifecycleOwner,openVerifyLoginScreenLiveDataObser)
    }

    val openVerifyLoginScreenLiveDataObser=Observer<Unit>{
        findNavController().navigate(R.id.action_loginScreen_to_verifyLoginScreen)
    }

    val openRegesterScreenLiveDataOser=Observer<Unit>{
        findNavController().navigate(R.id.action_loginScreen_to_signUpScreen)
    }
}