package com.opensource.armmovies.data.repository.tvshow

import com.opensource.armmovies.data.model.tvshow.TVShow

interface TVShowLocalDataSource {

    suspend fun getTVShowFromDB(): List<TVShow>
    suspend fun saveTVShowToDB(tvShows: List<TVShow>)
    suspend fun clearAll()

}