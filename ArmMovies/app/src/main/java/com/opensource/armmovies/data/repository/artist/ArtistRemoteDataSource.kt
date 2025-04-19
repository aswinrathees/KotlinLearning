package com.opensource.armmovies.data.repository.artist

import com.opensource.armmovies.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>
}