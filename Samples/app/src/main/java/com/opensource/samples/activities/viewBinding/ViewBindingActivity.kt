package com.opensource.samples.activities.viewBinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.opensource.samples.databinding.ActivityViewBindingBinding

class ViewBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGreet.setOnClickListener {
            binding.tvGreeting.text = "Hello, ${binding.etName.text}!"
        }
    }
}