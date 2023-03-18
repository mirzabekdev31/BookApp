package uz.gita.mirzabek.example.bookapp.prisentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.mirzabek.example.bookapp.data.remote.response.UserResponse
import uz.gita.mirzabek.example.bookapp.databinding.ItemBookBinding
import uz.gita.mirzabek.example.bookapp.databinding.UsersItemBinding

class UserAdapter :ListAdapter<UserResponse,UserAdapter.UserHolder>(ItemDiaffCallback){

    private var listener:((Int)->Unit)?=null
    fun setListener(block:(Int)->Unit){
        listener=block
    }


    object ItemDiaffCallback:DiffUtil.ItemCallback<UserResponse>(){
        override fun areItemsTheSame(oldItem: UserResponse, newItem: UserResponse): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: UserResponse, newItem: UserResponse): Boolean {
            return oldItem.id==newItem.id &&
                    oldItem.firstName==newItem.firstName &&
                    oldItem.lastName==newItem.lastName
        }

    }

    inner class UserHolder(private val binding: UsersItemBinding):RecyclerView.ViewHolder(binding.root){

        init {
            itemView.setOnClickListener {
                listener?.invoke(getItem(absoluteAdapterPosition).id)
            }
        }

        fun bind(){
            getItem(absoluteAdapterPosition).apply {
                binding.lastName.text=lastName
                binding.firstName.text=firstName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(UsersItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind()
    }
}