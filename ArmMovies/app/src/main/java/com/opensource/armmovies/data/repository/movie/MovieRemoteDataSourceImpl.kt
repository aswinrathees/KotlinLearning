package com.opensource.armmovies.data.repository.movie

import com.opensource.armmovies.data.api.ApiService
import com.opensource.armmovies.data.model.movie.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val apiService: ApiService, private val apiKey: String): MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = apiService.getPopularMovies(apiKey)
}