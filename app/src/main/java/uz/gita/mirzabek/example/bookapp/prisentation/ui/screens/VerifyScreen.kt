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
import uz.gita.mirzabek.example.bookapp.databinding.ScreenVerifyBinding
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl.VerifyViewModelImpl



@AndroidEntryPoint
class VerifyScreen : Fragment(R.layout.screen_verify) {


    private val viewModel by viewModels<VerifyViewModelImpl>()
    private val binding by viewBinding(ScreenVerifyBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)=binding.myApply {
        super.onViewCreated(view, savedInstanceState)
        BtnVerify.setOnClickListener { viewModel.verify(inputCode.text.toString()) }
        viewModel.openMainScreenLiveData.observe(viewLifecycleOwner,openMainScreenLiveDataObserver)

    }

    val openMainScreenLiveDataObserver=Observer<Unit>{
        findNavController().navigate(R.id.action_verifyScreen_to_bookScreen)
    }

}