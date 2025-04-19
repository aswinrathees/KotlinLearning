package com.opensource.armmovies.domain.repoInterfaces

import com.opensource.armmovies.data.model.tvshow.TVShow

interface TVShowRepository {

    suspend fun getTVShows(): List<TVShow>?
    suspend fun updateTVShows(): List<TVShow>?
}