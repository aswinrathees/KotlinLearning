package com.opensource.armmovies.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.opensource.armmovies.R
import com.opensource.armmovies.data.model.movie.Movie
import com.opensource.armmovies.databinding.ListItemBinding
import com.opensource.armmovies.presentation.movie.MovieAdapter.MovieViewHolder

class MovieAdapter() : RecyclerView.Adapter<MovieViewHolder>() {

    private var movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MovieViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.titleTextView.text = movie.title
            binding.itemDescription.text = movie.overview

            val imageUrl = "https://image.tmdb.org/t/p/w500" + movie.posterPath
            Glide
                .with(binding.itemImage.context)
                .load(imageUrl)
                .into(binding.itemImage)
        }
    }
}