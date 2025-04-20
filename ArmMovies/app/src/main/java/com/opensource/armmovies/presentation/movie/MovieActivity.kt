package com.opensource.armmovies.presentation.movie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.opensource.armmovies.R
import com.opensource.armmovies.databinding.ActivityMovieBinding
import com.opensource.armmovies.presentation.di.interfaces.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    private lateinit var bindingUtil: ActivityMovieBinding
    private lateinit var movieViewModel: MovieViewModel

    @Inject
    lateinit var factory: MovieViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this) {
            Log.i("MYTAG", it.toString())
        }
    }
}