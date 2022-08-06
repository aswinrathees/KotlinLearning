package com.opensource.databinding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.opensource.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.submitButton.setOnClickListener {
            displayGreeting()
        }
        binding.secondSample.setOnClickListener{
            val secondActivity = Intent(this,SecondActivity::class.java)
            startActivity(secondActivity)
        }
    }

    private fun displayGreeting() {
        // Method 1
        // binding.textView.setText(getString(R.string.hello) + " " + binding.editText.text)

        // Method 2
        binding.apply {
            textView.setText(getString(R.string.hello) + " " + editText.text)
        }

    }
}