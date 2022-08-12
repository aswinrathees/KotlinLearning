package com.opensource.viewmodellivedatawithdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.opensource.viewmodellivedatawithdatabinding.databinding.ActivityMainBinding
import com.opensource.viewmodellivedatawithdatabinding.viewmodel.AddViewModel
import com.opensource.viewmodellivedatawithdatabinding.viewmodel.AddViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: AddViewModel
    private lateinit var viewModelFactory: AddViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = AddViewModelFactory(125)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AddViewModel::class.java)
        binding.addViewModel = viewModel
        viewModel.totalValue.observe(this) {
            binding.textInputLayout.text = it.toString()
        }
    }
}