package com.opensource.armmovies.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.opensource.armmovies.data.model.tvshow.TVShow
import com.opensource.armmovies.databinding.ListItemBinding
import com.opensource.armmovies.presentation.tvshow.TVShowAdapter.TVShowViewHolder

class TVShowAdapter() : RecyclerView.Adapter<TVShowViewHolder>() {

    private var tvShowList = ArrayList<TVShow>()

    fun setList(tvShowList: List<TVShow>) {
        this.tvShowList.clear()
        this.tvShowList.addAll(tvShowList)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TVShowViewHolder {
        val layout = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layout, parent, false)
        return TVShowViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TVShowViewHolder,
        position: Int
    ) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    inner class TVShowViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TVShow) {
            binding.titleTextView.text = tvShow.title
            binding.itemDescription.text = tvShow.overview

            val posterURL = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
            Glide.with(binding.itemImage.context)
                .load(posterURL)
                .into(binding.itemImage)
        }
    }
}