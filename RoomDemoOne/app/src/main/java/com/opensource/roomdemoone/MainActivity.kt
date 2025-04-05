package com.opensource.roomdemoone

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.opensource.roomdemoone.databinding.ActivityMainBinding
import com.opensource.roomdemoone.helpers.SubscriberDao
import com.opensource.roomdemoone.helpers.SubscriberDatabase
import com.opensource.roomdemoone.helpers.SubscriberRecyclerViewAdapter
import com.opensource.roomdemoone.helpers.SubscriberViewModelFactory
import com.opensource.roomdemoone.model.Subscriber
import com.opensource.roomdemoone.model.SubscriberRepository
import com.opensource.roomdemoone.viewmodel.SubscriberViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao: SubscriberDao = SubscriberDatabase.getInstance(this).subscriberDao
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        subscriberViewModel = ViewModelProvider(this, factory).get(SubscriberViewModel::class.java)
        subscriberViewModel.message.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        binding.subscriberViewModel = subscriberViewModel
        binding.lifecycleOwner = this
        initRecyclerView()
    }

    private fun displaySubscriberList() {
        subscriberViewModel.subscribers.observe(this) {
            Log.i("DisplaySubscriberList", it.toString())
            binding.recyclerView.adapter =
                SubscriberRecyclerViewAdapter(it) { selectedItem: Subscriber ->
                    listItemClicked(
                        selectedItem
                    )
                }
        }
    }

    private fun listItemClicked(subscriber: Subscriber) {
        Toast.makeText(this, "Selected user is : ${subscriber.name}", Toast.LENGTH_SHORT).show()
        subscriberViewModel.initUpdateAndDelete(subscriber)
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        displaySubscriberList()
    }
}