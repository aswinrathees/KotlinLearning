package com.opensource.samples.activities.fragmentSamples.fragments.contacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.opensource.samples.R
import com.opensource.samples.activities.fragmentSamples.fragments.contacts.helpers.Person
import com.opensource.samples.activities.fragmentSamples.fragments.contacts.helpers.PersonAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [ContactListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactListFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerView.Adapter<*>
    lateinit var layoutManager: LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contact_list, container, false)
        recyclerView = view.findViewById(R.id.contactList)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        adapter = PersonAdapter((activity as ContactActivity).getContactList())
        recyclerView.adapter = adapter
        return view
    }

    fun notifyDataSetChanged() {
        adapter.notifyDataSetChanged()
    }
}