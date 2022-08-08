package com.opensource.viewmodeldemoonefactory

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.opensource.viewmodeldemoone.viewmodel.AddViewModel
import com.opensource.viewmodeldemoonefactory.databinding.ActivityMainBinding
import com.opensource.viewmodeldemoonefactory.viewmodel.AddViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var addViewModelFactory: AddViewModelFactory
    private lateinit var addViewModel: AddViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context: Context = this
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        addViewModelFactory = AddViewModelFactory(100)
        addViewModel = ViewModelProvider(this, addViewModelFactory).get(AddViewModel::class.java)
        binding.apply {
            addButton.setOnClickListener {
                if(inputEditText.text.toString() == "")
                    Toast.makeText(context,"Enter a value",Toast.LENGTH_SHORT).show()
                else {
                    textInputLayout.setText(
                        addViewModel.getTotal(
                            inputEditText.text.toString().toInt()
                        ).toString()
                    )
                }
            }
        }
    }
}