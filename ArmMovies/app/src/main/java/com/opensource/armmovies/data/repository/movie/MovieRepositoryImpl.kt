package com.opensource.armmovies.data.repository.movie

import android.util.Log
import com.opensource.armmovies.data.model.movie.Movie
import com.opensource.armmovies.domain.repoInterfaces.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newMovieList = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newMovieList)
        movieCacheDataSource.saveMoviesToCache(newMovieList)
        return newMovieList
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            response.body()?.let {
                movieList = it.results
            }
        } catch (exception: Exception) {
            Log.e("MyTAG", "Exception occured: ${exception.localizedMessage}")
        }

        return movieList
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()

            when (movieList.isNotEmpty()) {
                true -> return movieList
                false -> {
                    movieList = getMoviesFromAPI()
                    movieLocalDataSource.saveMoviesToDB(movieList)
                }
            }
        } catch (exception: Exception) {
            Log.e("MyTAG", "Exception occured: ${exception.localizedMessage}")
        }

        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

            when (movieList.isNotEmpty()) {
                true -> return movieList
                false -> {
                    movieList = getMoviesFromDB()
                    movieCacheDataSource.saveMoviesToCache(movieList)
                }
            }
        } catch (exception: Exception) {
            Log.e("MyTAG", "Exception occured: ${exception.localizedMessage}")
        }

        return movieList

    }
}