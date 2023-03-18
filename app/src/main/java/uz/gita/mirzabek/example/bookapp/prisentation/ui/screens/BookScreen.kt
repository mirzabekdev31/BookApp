package uz.gita.mirzabek.example.bookapp.prisentation.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import uz.gita.bookappauth.utils.myApply
import uz.gita.mirzabek.example.bookapp.R
import uz.gita.mirzabek.example.bookapp.data.local.room.entities.AddBookEntity
import uz.gita.mirzabek.example.bookapp.data.remote.request.UpdateBookRequest
import uz.gita.mirzabek.example.bookapp.data.remote.response.AddBookResponse
import uz.gita.mirzabek.example.bookapp.data.remote.response.DeleteBookResponse
import uz.gita.mirzabek.example.bookapp.data.remote.response.UpdateBookResponse
import uz.gita.mirzabek.example.bookapp.databinding.ScreenBookBinding
import uz.gita.mirzabek.example.bookapp.prisentation.ui.adapter.BooksAdapter
import uz.gita.mirzabek.example.bookapp.prisentation.ui.dialog.AddBooksDialog
import uz.gita.mirzabek.example.bookapp.prisentation.ui.dialog.UpdateBookDialog
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl.BookScreenViewModelImpl

@AndroidEntryPoint
class BookScreen : Fragment(R.layout.screen_book) {
    private val viewModel by viewModels<BookScreenViewModelImpl>()
    private val binding by viewBinding(ScreenBookBinding::bind)
    private val adapter = BooksAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.myApply {
        super.onViewCreated(view, savedInstanceState)
        listBooks.adapter = adapter
        listBooks.layoutManager = GridLayoutManager(requireContext(), 2)
        addBooks.setOnClickListener { viewModel.openAddContactDialog() }
        viewModel.addBookDialogLiveData.observe(this@BookScreen, addBookDialogLiveDataObserver)
        viewModel.bookLiveData.observe(viewLifecycleOwner, bookLiveDataObserver)
        viewModel.openUserScreenLivedata.observe(viewLifecycleOwner, openUserScreenLivedataObserver)
        viewModel.messageLiveData.observe(viewLifecycleOwner, messageLiveDataObserver)
        viewModel.openUpdateDialog.observe(viewLifecycleOwner, openUpdateDialogObserver)
        Users.setOnClickListener {
            Toast.makeText(requireContext(), "Hell Img", Toast.LENGTH_SHORT).show()
            viewModel.openUserScreen()
        }
        adapter.setDeleteListener {
            viewModel.deleteBook(it)
        }

    }

    private val addBookDialogLiveDataObserver = Observer<Unit> {
        val dialog = AddBooksDialog()
        dialog.setAddBooktListener {
            Toast.makeText(requireContext(), "Title ${it.title}", Toast.LENGTH_SHORT).show()
            viewModel.addBookS(
                title = it.title,
                description = it.description,
                author = it.author,
                pageCount = it.pageCount
            )
        }
        dialog.show(childFragmentManager, null)
    }

    private val bookLiveDataObserver = Observer<List<AddBookResponse>> {
        adapter.submitList(it)
    }

    private val openUserScreenLivedataObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_bookScreen_to_userScreen)
    }

    private val messageLiveDataObserver = Observer<DeleteBookResponse> {
        Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
        adapter.setDeleteListener {
            Toast.makeText(requireContext(), "Hello Listener", Toast.LENGTH_SHORT).show()
            viewModel.deleteBook(it)
        }
    }

    private val openUpdateDialogObserver = Observer<Unit> {
        val dialog = UpdateBookDialog()
        adapter.setEditListener { itt ->
            dialog.setAddBooktListener {
                viewModel.updateBook(
                    UpdateBookRequest(
                        itt.id,
                        itt.title,
                        itt.author,
                        itt.description,
                        itt.pageCount
                    )
                )
            }
        }
        dialog.show(childFragmentManager, null)
    }
}
