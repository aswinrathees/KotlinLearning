package com.opensource.armmovies.domain.usecases

import com.opensource.armmovies.domain.repoInterfaces.MovieRepository
import com.opensource.armmovies.data.model.movie.Movie

class UpdateTVShowsUseCase(private val repository: MovieRepository) {

    suspend fun execute(): List<Movie>? = repository.updateMovies()

}