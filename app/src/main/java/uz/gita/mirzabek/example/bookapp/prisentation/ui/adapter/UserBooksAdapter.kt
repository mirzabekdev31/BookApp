package uz.gita.mirzabek.example.bookapp.prisentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.mirzabek.example.bookapp.data.remote.response.UserBooksResponse
import uz.gita.mirzabek.example.bookapp.databinding.ScreenUserBooksItemBinding
import uz.gita.mirzabek.example.bookapp.databinding.UsersItemBinding

class UserBooksAdapter :ListAdapter<UserBooksResponse,UserBooksAdapter.Holder>(ItemDiffUtill){

    object ItemDiffUtill:DiffUtil.ItemCallback<UserBooksResponse>(){
        override fun areItemsTheSame(
            oldItem: UserBooksResponse,
            newItem: UserBooksResponse
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: UserBooksResponse,
            newItem: UserBooksResponse
        ): Boolean {
            return oldItem.id==newItem.id &&
                    oldItem.fav==newItem.fav &&
                    oldItem.isLike==newItem.isLike &&
                    oldItem.author==newItem.author &&
                    oldItem.description==newItem.description &&
                    oldItem.disLikeCount==newItem.disLikeCount &&
                    oldItem.likeCount==newItem.likeCount &&
                    oldItem.pageCount==newItem.pageCount
        }

    }

    inner class Holder(private val binding: ScreenUserBooksItemBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(){
            getItem(absoluteAdapterPosition).apply {
                binding.authorBook.text=author
                binding.descriptionBook.text=description
                binding.pageCountBook.text=pageCount
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ScreenUserBooksItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }

}