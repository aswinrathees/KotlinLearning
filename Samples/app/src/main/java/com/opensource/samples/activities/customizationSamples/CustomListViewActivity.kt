package com.opensource.samples.activities.customizationSamples

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.opensource.samples.R
import com.opensource.samples.activities.customizationSamples.helpers.Product
import com.opensource.samples.activities.customizationSamples.helpers.ProductAdapter

class CustomListViewActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private var arrayList: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_list_view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            listView = findViewById(R.id.products_lv)


            arrayList.add(Product("Macbook","Pro M2", "Laptop", 180000.0, true))
            arrayList.add(Product("Macbook","Pro M1", "Laptop", 160000.0, true))
            arrayList.add(Product("Macbook","Intel", "Laptop", 120000.0, true))

            listView.adapter = ProductAdapter(arrayList, this)
            insets
        }

    }
}