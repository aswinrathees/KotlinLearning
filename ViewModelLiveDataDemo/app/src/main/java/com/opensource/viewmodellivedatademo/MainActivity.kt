package com.opensource.viewmodellivedatademo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.opensource.viewmodellivedatademo.databinding.ActivityMainBinding
import com.opensource.viewmodellivedatademo.viewmodel.AddViewModel
import com.opensource.viewmodellivedatademo.viewmodel.AddViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: AddViewModel
    private lateinit var viewModelFactory: AddViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context: Context = this
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = AddViewModelFactory(125)
        viewModel = ViewModelProvider(this,viewModelFactory).get(AddViewModel::class.java)
        binding.apply {
            addButton.setOnClickListener {
                if(inputEditText.text.toString() == "")
                    Toast.makeText(context,"Enter a value", Toast.LENGTH_SHORT).show()
                else {
                    viewModel.setTotal(inputEditText.text.toString().toInt())
                }
            }
        }

        viewModel.totalData.observe(this, Observer{
            binding.textInputLayout.text = it.toString()
        })
    }
}