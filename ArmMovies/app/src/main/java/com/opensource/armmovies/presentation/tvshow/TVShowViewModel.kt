package com.opensource.armmovies.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.opensource.armmovies.domain.usecases.GetTVShowsUseCase
import com.opensource.armmovies.domain.usecases.UpdateTVShowsUseCase

class TVShowViewModel(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
): ViewModel() {

    fun getTVShows() = liveData {
        val tvShows = getTVShowsUseCase.execute()
        emit(tvShows)
    }

    fun updateTVShowList() = liveData {
        val tvShows = updateTVShowsUseCase.execute()
        emit(tvShows)
    }
}