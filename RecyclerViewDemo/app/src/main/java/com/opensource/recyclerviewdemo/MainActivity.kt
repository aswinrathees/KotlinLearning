package com.opensource.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.opensource.recyclerviewdemo.adapter.MyRecyclerViewAdapter
import com.opensource.recyclerviewdemo.helpers.Fruits

class MainActivity : AppCompatActivity() {
    private val fruitsList = listOf(
        Fruits("Apple", 120),
        Fruits("Mango", 90),
        Fruits("Orange", 190),
        Fruits("Guava", 60),
        Fruits("Avocado", 110),
        Fruits("Kiwi", 250),
        Fruits("Banana", 40),
        Fruits("Lemon", 20)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.setBackgroundColor(Color.GRAY)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(fruitsList) { selectedItem: Fruits ->
            listItemClicked(selectedItem)
        }
    }

    private fun listItemClicked(fruits: Fruits) {
        Toast.makeText(
            this,
            "Price/KG is ${fruits.pricePerKg}",
            Toast.LENGTH_SHORT
        ).show()
    }
}