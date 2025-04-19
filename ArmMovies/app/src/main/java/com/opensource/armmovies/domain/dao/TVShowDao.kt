package com.opensource.armmovies.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.opensource.armmovies.data.model.tvshow.TVShow

@Dao
interface TVShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvShows: List<TVShow>)

    @Query("Delete from popular_tv_shows")
    suspend fun deleteAllTVShows()

    @Query("Select * from popular_tv_shows")
    suspend fun getTVShows(): List<TVShow>
}