package com.opensource.samples.activities.fragmentSamples.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.opensource.samples.R
import com.opensource.samples.activities.fragmentSamples.fragments.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {

    private var columnCount = 1

    private lateinit var activity: ItemSelected

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as ItemSelected
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                PlaceholderContent.setItems(Pair(resources.getStringArray(R.array.pieces), resources.getStringArray(R.array.descriptions)))
                adapter = MyItemRecyclerViewAdapter(PlaceholderContent.ITEMS)
            }
        }
        return view
    }
}