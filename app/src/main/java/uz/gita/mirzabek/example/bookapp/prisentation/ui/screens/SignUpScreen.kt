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
import uz.gita.bookappauth.utils.state
import uz.gita.mirzabek.example.bookapp.R
import uz.gita.mirzabek.example.bookapp.databinding.ScreenSignUpBinding
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl.SignUpViewModelImpl



@AndroidEntryPoint
class SignUpScreen :Fragment(R.layout.screen_sign_up){

    private val viewModel by viewModels<SignUpViewModelImpl>()
    private val binding by viewBinding(ScreenSignUpBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =binding.myApply{
        super.onViewCreated(view, savedInstanceState)
        ButtonSignUp.setOnClickListener { viewModel.register(phone.text.toString(),password.text.toString(),LastName.text.toString(),firstName.text.toString())}
        viewModel.openVerifyScreenLiveData.observe(viewLifecycleOwner,openVerifyScreenLiveData)
        viewModel.progressLiveData.observe(viewLifecycleOwner,progressLiveDataObser)

    }

    val openVerifyScreenLiveData=Observer<Unit>{
        findNavController().navigate(R.id.action_signUpScreen_to_verifyScreen)
    }

    val progressLiveDataObser=Observer<Boolean>{
        binding.progress.state(it)
    }

}