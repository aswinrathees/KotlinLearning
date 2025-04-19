package com.opensource.armmovies.domain.repoInterfaces

import com.opensource.armmovies.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}