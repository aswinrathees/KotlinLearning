package com.opensource.armmovies.data.repository.artist

import android.util.Log
import com.opensource.armmovies.domain.repoInterfaces.ArtistRepository
import com.opensource.armmovies.data.model.artist.Artist

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? = getArtistsFromCache()

    override suspend fun updateArtists(): List<Artist>? {
        val artists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(artists)
        artistCacheDataSource.saveArtistsToCache(artists)
        return artists
    }

    private suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            response.body()?.let {
                artistList = it.results
            }
        } catch (exception: Exception) {
            Log.e("MyTAG", "Exception occured: ${exception.localizedMessage}")
        }

        return artistList
    }

    private suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val artists = artistLocalDataSource.getArtistsFromDB()

            when (artists.isNotEmpty()) {
                true -> return artists
                false -> {
                    artistList = getArtistsFromAPI()
                    artistLocalDataSource.saveArtistsToDB(artistList)
                    return artistList
                }
            }
        } catch (exception: Exception) {
            Log.e("MyTAG", "Exception occured: ${exception.localizedMessage}")
        }

        return artistList
    }

    private suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val artists = artistCacheDataSource.getArtistsFromCache()

            when (artists.isNotEmpty()) {
                true -> return artists
                false -> {
                    artistList = getArtistsFromDB()
                    artistCacheDataSource.saveArtistsToCache(artistList)
                    return artistList
                }
            }
        } catch (exception: Exception) {
            Log.e("MyTAG", "Exception occured: ${exception.localizedMessage}")
        }

        return artistList
    }
}