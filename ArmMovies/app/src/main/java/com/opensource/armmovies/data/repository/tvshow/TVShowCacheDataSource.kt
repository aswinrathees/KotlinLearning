package com.opensource.armmovies.data.repository.tvshow

import com.opensource.armmovies.data.model.tvshow.TVShow

interface TVShowCacheDataSource {

    suspend fun getTVShowsFromCache(): List<TVShow>
    suspend fun saveTVShowsToCache(tvShows: List<TVShow>)

}