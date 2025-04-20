package com.opensource.armmovies.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.opensource.armmovies.domain.usecases.GetTVShowsUseCase
import com.opensource.armmovies.domain.usecases.UpdateTVShowsUseCase

class TVShowViewModelFactory(
    private val tvShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TVShowViewModel(tvShowsUseCase, updateTVShowsUseCase) as T
    }
}