package com.opensource.recyclerviewdemo

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.opensource.recyclerviewdemo.adapter.FruitsRecyclerViewAdapter
import com.opensource.recyclerviewdemo.helpers.Fruits

class FruitsActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_fruits)

        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setBackgroundColor(Color.GRAY)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FruitsRecyclerViewAdapter(fruitsList) { selectedItem: Fruits ->
            Toast.makeText(
                this,
                "Price/KG is ${selectedItem.pricePerKg}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}