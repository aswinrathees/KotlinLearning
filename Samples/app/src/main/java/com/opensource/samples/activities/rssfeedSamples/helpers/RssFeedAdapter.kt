package com.opensource.samples.activities.rssfeedSamples.helpers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.opensource.samples.databinding.RssFeedLayoutBinding

class RssFeedAdapter(private val rssFeedList: ArrayList<RssFeedModel>): RecyclerView.Adapter<RssFeedAdapter.RssFeedViewHolder>() {

    inner class RssFeedViewHolder(binding: RssFeedLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        val title = binding.rssFeedTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RssFeedViewHolder {
        return RssFeedViewHolder(RssFeedLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return rssFeedList.size
    }

    override fun onBindViewHolder(holder: RssFeedViewHolder, position: Int) {
        holder.itemView.tag = rssFeedList[position]
        holder.title.text = rssFeedList[position].title
    }
}