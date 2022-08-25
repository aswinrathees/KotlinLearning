package com.opensource.roomdemoone.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.opensource.roomdemoone.R
import com.opensource.roomdemoone.databinding.ListItemBinding

import com.opensource.roomdemoone.model.Subscriber

class SubscriberRecyclerViewAdapter(
    private var subscribers: List<Subscriber>,
    private val clickListener: (Subscriber) -> Unit
) :
    RecyclerView.Adapter<SubscriberViewHolder>() {
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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return SubscriberViewHolder(binding)
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
    override fun onBindViewHolder(holder: SubscriberViewHolder, position: Int) {
        holder.bind(subscribers[position],clickListener)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return subscribers.size
    }
}

class SubscriberViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(subscriber: Subscriber,clickListener: (Subscriber) -> Unit) {
        Log.i("----DisplaySubscriberList", subscriber.name)
        binding.nameView.text = subscriber.name
        binding.emailView.text = subscriber.email
        binding.cardb.setOnClickListener {
            clickListener(subscriber)
        }
    }
}