package com.opensource.armmovies.domain.repoInterfaces

import com.opensource.armmovies.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}