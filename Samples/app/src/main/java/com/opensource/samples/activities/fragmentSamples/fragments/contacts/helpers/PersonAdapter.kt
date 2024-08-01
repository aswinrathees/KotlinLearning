package com.opensource.samples.activities.fragmentSamples.fragments.contacts.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.opensource.samples.databinding.RowLayoutBinding

class PersonAdapter(private val persons: List<Person>): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    private lateinit var personClicked: PersonClicked

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        personClicked = parent.context as PersonClicked

        return PersonViewHolder(
            RowLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder:PersonViewHolder, position: Int) {
        holder.itemView.setTag(persons[position])

        holder.contactNameTv.text = persons[position].contactName
        //holder.contactIcon = persons[position].contactNumber
    }

    inner class PersonViewHolder(binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val contactNameTv: TextView = binding.contactItemName
        val contactIcon: ImageView = binding.contactIcon

        init {
            itemView.setOnClickListener {
                Log.e("XX", "Contact name clicked :${contactNameTv.text}")
               personClicked.onItemClicked(itemView.getTag() as Person)
            }
        }
    }
}

interface PersonClicked {
    fun onItemClicked(person: Person)
}