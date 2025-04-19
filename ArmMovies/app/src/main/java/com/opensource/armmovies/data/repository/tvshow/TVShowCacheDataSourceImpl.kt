package com.opensource.armmovies.data.repository.tvshow

import com.opensource.armmovies.data.model.tvshow.TVShow

class TVShowCacheDataSourceImpl: TVShowCacheDataSource {

    private var tvShowList = ArrayList<TVShow>()

    override suspend fun getTVShowsFromCache(): List<TVShow> = tvShowList

    override suspend fun saveTVShowsToCache(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList = tvShows as ArrayList<TVShow>
    }
}