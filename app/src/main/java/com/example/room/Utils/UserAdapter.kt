package com.example.room.Utils

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.AsyncListUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.room.DB.UserEntity
import com.example.room.UpdateUserActivity
import com.example.room.databinding.ItemUserBinding
import java.util.Objects

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var binding: ItemUserBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        binding = ItemUserBinding.inflate(inflater,parent,false)
        context = parent.context
        return  ViewHolder()
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        fun bind (item : UserEntity) {
            binding.apply {
                itemUserinfo.text = "${item.userId} - ${item.userName}  ${item.userAge} ${item.Phonenumber}"
                root.setOnClickListener {
                    val intent = Intent(context , UpdateUserActivity::class.java)
                    intent.putExtra(Constans.BUNDLE_USER_ID , item.userId)
                    context.startActivity(intent)
                }
            }
        }
    }

    private val differCallbacks = object : DiffUtil.ItemCallback<UserEntity>(){
        override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem.userId == newItem.userId
        }

        override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this , differCallbacks)
}