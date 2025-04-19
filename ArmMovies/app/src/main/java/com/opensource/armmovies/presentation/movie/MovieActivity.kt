package com.opensource.armmovies.presentation.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.opensource.armmovies.R
import com.opensource.armmovies.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var bindingUtil: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        setContentView(bindingUtil.root)
    }
}