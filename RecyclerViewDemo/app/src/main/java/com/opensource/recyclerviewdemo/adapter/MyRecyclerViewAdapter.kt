package com.opensource.recyclerviewdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.opensource.recyclerviewdemo.R
import com.opensource.recyclerviewdemo.helpers.Fruits

class MyRecyclerViewAdapter(
    private val fruitsList: List<Fruits>,
    private val clickListener: (Fruits) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {
    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val layout = layoutInflater.inflate(R.layout.list_view, parent, false)
        return MyViewHolder(layout)
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(fruitsList[position],clickListener)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return fruitsList.size
    }
}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(fruit: Fruits,clickListener: (Fruits) -> Unit) {
        val textView = view.findViewById<TextView>(R.id.textView)
        textView.text = fruit.name
        view.setOnClickListener {
            // Method 1
            //Toast.makeText(view.context, "Selected Fruit: ${fruit.name}", Toast.LENGTH_SHORT).show()

            // Method 2
            clickListener(fruit)
        }
    }
}