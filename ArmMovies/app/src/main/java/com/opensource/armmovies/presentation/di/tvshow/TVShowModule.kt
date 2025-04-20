package com.opensource.armmovies.presentation.di.tvshow

import com.opensource.armmovies.domain.usecases.GetTVShowsUseCase
import com.opensource.armmovies.domain.usecases.UpdateTVShowsUseCase
import com.opensource.armmovies.presentation.tvshow.TVShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TVShowModule {

    @TVShowScope
    @Provides
    fun provideTVShowViewModelFactory(
        getTVShowsUseCase: GetTVShowsUseCase,
        updateTVShowsUseCase: UpdateTVShowsUseCase
    ): TVShowViewModelFactory {
        return TVShowViewModelFactory(getTVShowsUseCase, updateTVShowsUseCase)
    }
}