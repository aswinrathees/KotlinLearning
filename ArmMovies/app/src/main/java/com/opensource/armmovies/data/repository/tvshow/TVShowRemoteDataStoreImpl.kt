package com.opensource.armmovies.data.repository.tvshow

import com.opensource.armmovies.data.api.ApiService
import com.opensource.armmovies.data.model.tvshow.TVShowList
import retrofit2.Response

class TVShowRemoteDataStoreImpl(private val apiService: ApiService, private val apiKey: String): TVShowRemoteDataStore {

    override suspend fun getTVShows(): Response<TVShowList> = apiService.getPopularTVShows(apiKey)
}