package com.opensource.samples.activities.fragmentSamples.fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.opensource.samples.activities.fragmentSamples.fragments.placeholder.PlaceholderContent.PlaceholderItem
import com.opensource.samples.databinding.FragmentItemBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 */
class MyItemRecyclerViewAdapter(

    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    private lateinit var itemSelected: ItemSelected

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemSelected = parent.context as ItemSelected

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }

        init {
            itemView.setOnClickListener {
                itemSelected.onItemSelected(bindingAdapterPosition)
            }
        }
    }
}

internal interface ItemSelected {
    fun onItemSelected(index: Int)
}