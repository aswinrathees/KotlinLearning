package com.opensource.armmovies.data.repository.tvshow

import com.opensource.armmovies.data.model.tvshow.TVShow
import com.opensource.armmovies.domain.dao.TVShowDao

class TVShowLocalDataStoreImpl(private val tvShowDao: TVShowDao):
    com.opensource.armmovies.data.repository.tvshow.TVShowLocalDataSource {

    override suspend fun getTVShowFromDB(): List<TVShow> = tvShowDao.getTVShows()

    override suspend fun saveTVShowToDB(tvShows: List<TVShow>) {
        tvShowDao.deleteAllTVShows()
        tvShowDao.saveTVShows(tvShows)
    }

    override suspend fun clearAll() {
        tvShowDao.deleteAllTVShows()
    }
}