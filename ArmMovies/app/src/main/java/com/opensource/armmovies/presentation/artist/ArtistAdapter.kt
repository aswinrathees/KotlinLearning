package com.opensource.armmovies.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.opensource.armmovies.data.model.artist.Artist
import com.opensource.armmovies.databinding.ListItemBinding

class ArtistAdapter: RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    private var artistList = ArrayList<Artist>()

    fun setList(artistList: List<Artist>) {
        this.artistList.clear()
        this.artistList.addAll(artistList)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArtistViewHolder {
        val layout = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layout, parent, false)
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ArtistViewHolder,
        position: Int
    ) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    inner class ArtistViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(artist: Artist) {
            binding.titleTextView.text = artist.name
            binding.itemDescription.text = artist.popularity.toString()
            val posterURL = "https://image.tmdb.org/t/p/w500" + artist.profilePath
            Glide.with(binding.itemImage.context)
                .load(posterURL)
                .into(binding.itemImage)
        }
    }
}