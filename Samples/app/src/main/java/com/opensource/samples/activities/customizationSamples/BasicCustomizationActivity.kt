package com.opensource.samples.activities.customizationSamples

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.opensource.samples.R

class BasicCustomizationActivity : AppCompatActivity() {

    lateinit var etFirstName: AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_basic_customization)
        etFirstName = findViewById(R.id.etFirstName)

        val names: Array<String> = arrayOf("Aswin", "Rathees", "Mini")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, names)
        etFirstName.setAdapter(adapter)
        etFirstName.threshold = 1
        etFirstName.setAdapter(adapter)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}