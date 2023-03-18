package uz.gita.mirzabek.example.bookapp.prisentation.ui.dialog

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.bookappauth.utils.myApply
import uz.gita.mirzabek.example.bookapp.R
import uz.gita.mirzabek.example.bookapp.data.remote.request.AddBookRequest
import uz.gita.mirzabek.example.bookapp.data.remote.request.UpdateBookRequest
import uz.gita.mirzabek.example.bookapp.databinding.AddBookDialogBinding

class UpdateBookDialog : DialogFragment(R.layout.add_book_dialog){

    private val binding by viewBinding(AddBookDialogBinding::bind)


    private var addBookListener: ((AddBookRequest) -> Unit)? = null

    fun setAddBooktListener(block:(AddBookRequest)->Unit){
        addBookListener=block
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =binding.myApply{
        super.onViewCreated(view, savedInstanceState)
        val title=inputTitle.text.toString()
        val discription=inputDescription.text.toString()
        val author=inputAuthor.text.toString()
        val pageCount=inputPageCount.text.toString().toIntOrNull()?:0

        ButtonSubmit.setOnClickListener {
            addBookListener?.invoke(
                AddBookRequest(
                    title = title,
                    description = discription,
                    author = author,
                    pageCount = pageCount)
            )
           dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
        val params = dialog!!.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params
    }
}