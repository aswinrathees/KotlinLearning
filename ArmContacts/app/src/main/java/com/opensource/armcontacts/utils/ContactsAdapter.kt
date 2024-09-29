package com.opensource.armcontacts.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.opensource.armcontacts.databinding.RowLayoutBinding

class ContactsAdapter(private val contacts: List<Contact>):
    RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    private lateinit var itemSelected: ItemSelected

    inner class ContactViewHolder(binding: RowLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        val contactName: TextView = binding.tvContactName
        val contactNumber: TextView = binding.tvContactPhone
        val contactEmail: TextView = binding.tvContactEmail

        init {
            itemView.setOnClickListener {
                itemSelected.onItemSelected(it.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        itemSelected = parent.context as ItemSelected
        return ContactViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.itemView.tag = contacts[position]

        holder.contactName.text = contacts[position].name
        holder.contactNumber.text = contacts[position].phone
        holder.contactEmail.text = contacts[position].email
    }
}

internal interface ItemSelected {
    fun onItemSelected(index: Int)
}