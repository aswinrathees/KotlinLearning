package com.opensource.armmovies.domain.usecases

import com.opensource.armmovies.domain.repoInterfaces.ArtistRepository
import com.opensource.armmovies.data.model.artist.Artist

class GetArtistsUseCase(private val repository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = repository.getArtists()
}