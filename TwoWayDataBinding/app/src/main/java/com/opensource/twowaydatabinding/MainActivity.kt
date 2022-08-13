package com.opensource.twowaydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.opensource.twowaydatabinding.databinding.ActivityMainBinding
import com.opensource.twowaydatabinding.viewmodel.NameViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var nameViewModel: NameViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        nameViewModel = ViewModelProvider(this).get(NameViewModel::class.java)
        binding.nameViewModel = nameViewModel
        binding.lifecycleOwner = this
    }
}