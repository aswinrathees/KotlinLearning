package com.opensource.recyclerviewdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.opensource.recyclerviewdemo.R
import com.opensource.recyclerviewdemo.helpers.Fruits

class FruitsRecyclerViewAdapter(private val fruitsList: List<Fruits>, private val clickListener: (Fruits) -> Unit): RecyclerView.Adapter<FruitsRecyclerViewAdapter.FruitsViewHolder>() {

    inner class FruitsViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun bind(fruits: Fruits, clickListener: (Fruits) -> Unit) {
            val textView = view.findViewById<TextView>(R.id.fruitName)
            textView.text = fruits.name
            view.setOnClickListener {
                clickListener(fruits)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        val layout = LayoutInflater.from(parent.context)
        val listItem = layout.inflate(R.layout.fruit_list_view, parent, false)
        return FruitsViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        holder.bind(fruitsList[position], clickListener)
    }
}