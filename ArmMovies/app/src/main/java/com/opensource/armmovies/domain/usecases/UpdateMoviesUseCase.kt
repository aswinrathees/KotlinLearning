package com.opensource.armmovies.domain.usecases

import com.opensource.armmovies.domain.repoInterfaces.MovieRepository
import com.opensource.armmovies.data.model.movie.Movie

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}