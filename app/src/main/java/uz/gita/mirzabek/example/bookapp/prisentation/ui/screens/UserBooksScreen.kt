package uz.gita.mirzabek.example.bookapp.prisentation.ui.screens
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.bookappauth.utils.myApply
import uz.gita.mirzabek.example.bookapp.R
import uz.gita.mirzabek.example.bookapp.data.remote.response.UserBooksResponse
import uz.gita.mirzabek.example.bookapp.databinding.ScreenUserBooksBinding
import uz.gita.mirzabek.example.bookapp.prisentation.ui.adapter.UserBooksAdapter
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl.UserBooksViewModelImpl



@AndroidEntryPoint
class UserBooksScreen :Fragment(R.layout.screen_user_books){
    private val viewModel by viewModels<UserBooksViewModelImpl>()
    private val binding by viewBinding(ScreenUserBooksBinding::bind)
    private val adapter=UserBooksAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =binding.myApply{
        super.onViewCreated(view, savedInstanceState)
        userBooksList.adapter=adapter
        userBooksList.layoutManager=LinearLayoutManager(requireContext())
        val bundle=Bundle()
        val userId=bundle.getInt("Idd")
        Log.d("TTT","$userId")
       // viewModel.loadBooks(2)
        viewModel.useBooksLiveData.observe(viewLifecycleOwner,useBooksLiveDataObserver)
    }

    private val useBooksLiveDataObserver=Observer<List<UserBooksResponse>>{
        adapter.submitList(it)
    }
}