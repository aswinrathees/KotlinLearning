package com.opensource.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.opensource.databinding.data.Student
import com.opensource.databinding.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        // Method 1
        binding.submitButton.setOnClickListener {
            binding.student = loadData()
        }
        // Method 2
        // binding.student = loadData()
    }

    private fun loadData(): Student {
        // Here id should not be displayed as it will crash the application
        return Student(1, "Aswin R", "B.Tech CSE")
    }
}