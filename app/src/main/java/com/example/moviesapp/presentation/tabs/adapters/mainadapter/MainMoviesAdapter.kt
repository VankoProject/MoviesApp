package com.example.moviesapp.presentation.tabs.adapters.mainadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.moviesapp.databinding.MovieItemBinding
import com.example.moviesapp.domain.model.MovieInfo

class MainMoviesAdapter(
    private val context: Context
) : ListAdapter<MovieInfo, MainViewHolder>(MovieInfoDiffCallBack) {

    var onMovieClickListener: OnMovieClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movieItem = getItem(position)
        with(holder) {
            binding.tvTitle.text = movieItem.title
            binding.tvReleaseDate.text = movieItem.releaseDate
            Glide.with(context)
                .load(URL_POSTER + movieItem.posterPath)
                .centerCrop()
                .into(binding.ivPoster)
            binding.ivPoster.setOnClickListener {
                onMovieClickListener?.onMovieClick(this)
            }
        }


    }

    companion object {
        private const val URL_POSTER = "https://image.tmdb.org/t/p/w500"
    }

    interface OnMovieClickListener{
        fun onMovieClick(movieInfo: MainViewHolder)
    }
}