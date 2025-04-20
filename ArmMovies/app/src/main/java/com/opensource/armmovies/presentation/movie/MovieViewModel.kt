package com.opensource.armmovies.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.opensource.armmovies.domain.usecases.GetMoviesUseCase
import com.opensource.armmovies.domain.usecases.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovieList() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}