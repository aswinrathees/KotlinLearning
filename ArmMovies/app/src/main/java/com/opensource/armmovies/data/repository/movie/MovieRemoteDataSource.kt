package com.opensource.armmovies.data.repository.movie

import com.opensource.armmovies.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}