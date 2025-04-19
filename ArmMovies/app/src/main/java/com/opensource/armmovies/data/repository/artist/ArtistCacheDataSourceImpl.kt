package com.opensource.armmovies.data.repository.artist

import com.opensource.armmovies.data.model.artist.Artist

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {

    private val artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }
}