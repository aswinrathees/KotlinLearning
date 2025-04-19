package com.opensource.armmovies.data.repository.artist

import com.opensource.armmovies.data.api.ApiService
import com.opensource.armmovies.data.model.artist.ArtistList
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val apiService: ApiService, private val apiKey: String): ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> = apiService.getPopularArtists(apiKey)
}