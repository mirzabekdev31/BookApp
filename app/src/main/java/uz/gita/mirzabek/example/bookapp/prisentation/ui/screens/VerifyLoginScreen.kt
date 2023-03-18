package uz.gita.mirzabek.example.bookapp.prisentation.ui.screens

import android.annotation.SuppressLint
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
import uz.gita.mirzabek.example.bookapp.databinding.ScreenLoginVerifyBinding
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl.VerifyLoginViewModelImpl


@AndroidEntryPoint
class VerifyLoginScreen :Fragment(R.layout.screen_login_verify){

    private val viewModel by viewModels<VerifyLoginViewModelImpl>()
    private val binding by viewBinding(ScreenLoginVerifyBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)=binding.myApply {
        super.onViewCreated(view, savedInstanceState)
        BtnVerifyLogin.setOnClickListener { viewModel.verifyLogin(inputCodeLogin.text.toString()) }
        viewModel.openMainScreenLiveData.observe(viewLifecycleOwner,openMainScreenLiveDataObserver)
    }

    val openMainScreenLiveDataObserver=Observer<Unit>{
        findNavController().navigate(R.id.action_verifyLoginScreen_to_bookScreen)
    }
}