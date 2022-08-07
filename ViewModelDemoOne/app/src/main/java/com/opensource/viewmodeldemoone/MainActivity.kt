package com.opensource.viewmodeldemoone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.opensource.viewmodeldemoone.databinding.ActivityMainBinding
import com.opensource.viewmodeldemoone.viewmodel.CountViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var countViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        countViewModel = ViewModelProvider(this).get(CountViewModel::class.java)
        binding.textView.setText(countViewModel.getCurrentCount().toString())

        binding.button.setOnClickListener {
            binding.textView.setText(countViewModel.getUpdatedCount().toString())
        }

        binding.addButton.setOnClickListener {
            binding.textInputLayout.setText(countViewModel.getTotal(binding.inputEditText.text.toString().toInt()).toString())
        }
    }
}