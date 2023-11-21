package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.retrofit.Models.ResponseMoviesList
import com.example.retrofit.databinding.ItemMoviesBinding
import java.util.zip.Inflater

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private lateinit var binding: ItemMoviesBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
    binding = ItemMoviesBinding.inflate(inflater , parent , false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) {
        holder.moviebind(moviediffer.currentList[position])
    }

    override fun getItemCount(): Int {
      return moviediffer.currentList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root){

        fun moviebind(item : ResponseMoviesList.Data){
            binding.apply {
                movieImg.load(item.poster)
                movieName.text = item.title
            }
        }
    }

    private val differcallback = object :DiffUtil.ItemCallback<ResponseMoviesList.Data>(){
        override fun areItemsTheSame(oldItem: ResponseMoviesList.Data, newItem: ResponseMoviesList.Data): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: ResponseMoviesList.Data, newItem: ResponseMoviesList.Data): Boolean {
            return oldItem==newItem
        }
    }

    val moviediffer =AsyncListDiffer(this , differcallback)
}