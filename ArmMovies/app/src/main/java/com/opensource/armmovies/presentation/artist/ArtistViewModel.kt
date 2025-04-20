package com.opensource.armmovies.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.opensource.armmovies.domain.usecases.GetArtistsUseCase
import com.opensource.armmovies.domain.usecases.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {

    fun getArtists() = liveData {
        val artists = getArtistsUseCase.execute()
        emit(artists)
    }

    fun updateArtistList() = liveData {
        val artists = updateArtistsUseCase.execute()
        emit(artists)
    }
}