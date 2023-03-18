package uz.gita.mirzabek.example.bookapp.prisentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.mirzabek.example.bookapp.app.App
import uz.gita.mirzabek.example.bookapp.data.local.room.entities.AddBookEntity
import uz.gita.mirzabek.example.bookapp.data.remote.response.AddBookResponse
import uz.gita.mirzabek.example.bookapp.databinding.ItemBookBinding

class BooksAdapter :ListAdapter<AddBookResponse,BooksAdapter.Holder>(ItemDiffUtil){


    private var deleteListener:((Int)->Unit)?=null
    fun setDeleteListener(block:(Int)->Unit){
        deleteListener=block
    }

    private var editListener:((AddBookEntity)->Unit)?=null

    fun setEditListener(block:(AddBookEntity)->Unit){
        editListener=block
    }


    object ItemDiffUtil:DiffUtil.ItemCallback<AddBookResponse>(){
        override fun areItemsTheSame(
            oldItem: AddBookResponse,
            newItem: AddBookResponse
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: AddBookResponse,
            newItem: AddBookResponse
        ): Boolean {
            return oldItem.id==newItem.id &&
                    oldItem.fav==newItem.fav &&
                    oldItem.author==newItem.author &&
                    oldItem.description==newItem.description &&
                    oldItem.pageCount==newItem.pageCount &&
                    oldItem.title==newItem.title
        }

    }

    inner class Holder(private val binding: ItemBookBinding):RecyclerView.ViewHolder(binding.root){

        init {

            binding.delete.setOnClickListener {
              //  Toast.makeText(App.instance,"Hi",Toast.LENGTH_SHORT).show()
                deleteListener?.invoke(getItem(absoluteAdapterPosition).id)
            }

            binding.edit.setOnClickListener {
                editListener?.invoke(getItem(absoluteAdapterPosition) as AddBookEntity)
            }

        }

        fun bind(){
            getItem(absoluteAdapterPosition).apply {
                binding.titleBook.text=title
                binding.descriptionBook.text=description
                binding.authorBook.text=author
                binding.pageCountBook.text=pageCount.toString()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
       return Holder(ItemBookBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }
}