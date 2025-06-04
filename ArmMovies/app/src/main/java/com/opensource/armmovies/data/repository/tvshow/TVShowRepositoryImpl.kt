package com.opensource.armmovies.data.repository.tvshow

import android.util.Log
import com.opensource.armmovies.data.model.tvshow.TVShow
import com.opensource.armmovies.domain.repoInterfaces.TVShowRepository

class TVShowRepositoryImpl(
    private val tvShowRemoteDataStore: TVShowRemoteDataStore,
    private val tvShowLocalDataStore: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource
): TVShowRepository {

    override suspend fun getTVShows(): List<TVShow>? = getTVShowsFromCache()

    override suspend fun updateTVShows(): List<TVShow>? {
        val newTVShowList = getTVShowsFromAPI()
        tvShowLocalDataStore.clearAll()
        tvShowLocalDataStore.saveTVShowToDB(newTVShowList)
        tvShowCacheDataSource.saveTVShowsToCache(newTVShowList)
        return newTVShowList
    }

    private suspend fun getTVShowsFromAPI(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>

        try {
            val response = tvShowRemoteDataStore.getTVShows()
            response.body()?.let {
                tvShowList = it.results
            }
        } catch (exception: Exception) {
            Log.e("MyTAG", "Exception occured: ${exception.localizedMessage}")
        }
        return tvShowList
    }

    private suspend fun getTVShowsFromDB(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>

        try {
            tvShowList = tvShowLocalDataStore.getTVShowFromDB()

            when (tvShowList.isNotEmpty()) {
                true -> return tvShowList
                false -> {
                    tvShowList = getTVShowsFromAPI()
                    tvShowLocalDataStore.saveTVShowToDB(tvShowList)
                }
            }
        } catch (exception: Exception) {
            Log.e("MyTAG", "Exception occured: ${exception.localizedMessage}")
        }

        return tvShowList
    }

    private suspend fun getTVShowsFromCache(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>

        try {
            tvShowList = tvShowCacheDataSource.getTVShowsFromCache()

            when (tvShowList.isNotEmpty()) {
                true -> return tvShowList
                false -> {
                    tvShowList = getTVShowsFromDB()
                    tvShowCacheDataSource.saveTVShowsToCache(tvShowList)
                }
            }
        } catch (exception: Exception) {
            Log.e("MyTAG", "Exception occured: ${exception.localizedMessage}")
        }

        return tvShowList

    }
}