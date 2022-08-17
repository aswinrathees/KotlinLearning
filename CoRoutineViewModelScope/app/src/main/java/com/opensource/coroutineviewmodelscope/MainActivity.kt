package com.opensource.coroutineviewmodelscope

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.opensource.coroutineviewmodelscope.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.getUserData()
        viewModel.user.observe(this) {
            it.forEach {
                Log.i("ViewModelScope", "Name is ${it.name}")
            }

        }
    }
}