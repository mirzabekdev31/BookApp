package uz.gita.mirzabek.example.bookapp.prisentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.bookappauth.utils.myApply
import uz.gita.mirzabek.example.bookapp.R
import uz.gita.mirzabek.example.bookapp.data.remote.response.UserResponse
import uz.gita.mirzabek.example.bookapp.databinding.ScreenLoginBinding
import uz.gita.mirzabek.example.bookapp.databinding.ScreenUsersBinding
import uz.gita.mirzabek.example.bookapp.prisentation.ui.adapter.UserAdapter
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl.LoginViewModelImpl
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl.UserViewModelImpl



@AndroidEntryPoint
class UserScreen :Fragment(R.layout.screen_users){

    private val viewModel by viewModels<UserViewModelImpl>()
    private val binding by viewBinding(ScreenUsersBinding::bind)
    private val adapter=UserAdapter()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =binding.myApply{
        super.onViewCreated(view, savedInstanceState)
        userList.adapter=adapter
        userList.layoutManager=LinearLayoutManager(requireContext())
        viewModel.backLiveData.observe(viewLifecycleOwner,backLiveDataObser)
        backBtn.setOnClickListener { viewModel.back() }
        viewModel.useLiveData.observe(viewLifecycleOwner,useLiveDataObser)
        viewModel.openUserBooksScreenLiveData.observe(viewLifecycleOwner,openUserBooksScreenLiveDataObserver)
        viewModel.openUserBooksScreen()
    }

    val backLiveDataObser=Observer<Unit>{
        findNavController().navigate(R.id.action_userScreen_to_bookScreen)
    }

    val useLiveDataObser=Observer<List<UserResponse>>{
        adapter.submitList(it)
    }

    val openUserBooksScreenLiveDataObserver= Observer<Unit> {
        adapter.setListener {
            val bundle=Bundle()
            arguments=bundle
            bundle.putInt("Idd",it)
            findNavController().navigate(R.id.action_userScreen_to_userBooksScreen,arguments)
        }
    }
}