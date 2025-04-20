package com.opensource.armmovies.presentation.di.movie

import com.opensource.armmovies.domain.usecases.GetMoviesUseCase
import com.opensource.armmovies.domain.usecases.UpdateMoviesUseCase
import com.opensource.armmovies.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideTVShowViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}