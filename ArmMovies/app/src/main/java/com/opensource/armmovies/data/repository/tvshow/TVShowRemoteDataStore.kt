package com.opensource.armmovies.data.repository.tvshow

import com.opensource.armmovies.data.model.tvshow.TVShowList
import retrofit2.Response

interface TVShowRemoteDataStore {

    suspend fun getTVShows(): Response<TVShowList>
}