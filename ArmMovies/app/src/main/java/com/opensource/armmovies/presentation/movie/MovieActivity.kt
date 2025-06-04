package com.opensource.armmovies.presentation.movie

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.opensource.armmovies.R
import com.opensource.armmovies.databinding.ActivityMovieBinding
import com.opensource.armmovies.presentation.di.interfaces.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    private lateinit var bindingUtil: ActivityMovieBinding
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    @Inject
    lateinit var factory: MovieViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        bindingUtil.movieList.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter()
        bindingUtil.movieList.adapter = movieAdapter

        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        bindingUtil.movieProgressBar.visibility = View.VISIBLE
        val responseData = movieViewModel.getMovies()
        responseData.observe(this) {
            when {
                it != null -> {
                    movieAdapter.setList(it)
                    movieAdapter.notifyDataSetChanged()
                    bindingUtil.movieProgressBar.visibility = View.GONE
                }
                else -> {
                    bindingUtil.movieProgressBar.visibility = View.GONE
                    Log.e("MyTAG", "Error occured")
                }
            }
        }
    }
}