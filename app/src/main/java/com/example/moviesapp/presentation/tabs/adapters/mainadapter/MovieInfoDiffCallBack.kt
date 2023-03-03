package com.example.moviesapp.presentation.tabs.adapters.mainadapter

import androidx.recyclerview.widget.DiffUtil
import com.example.moviesapp.domain.model.MovieInfo

object MovieInfoDiffCallBack: DiffUtil.ItemCallback<MovieInfo>() {


    override fun areItemsTheSame(oldItem: MovieInfo, newItem: MovieInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieInfo, newItem: MovieInfo): Boolean {
        return oldItem == newItem
    }


}