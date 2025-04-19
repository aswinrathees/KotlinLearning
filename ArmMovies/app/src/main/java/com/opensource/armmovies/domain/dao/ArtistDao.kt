package com.opensource.armmovies.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.opensource.armmovies.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

    @Query("DELETE from popular_artists")
    suspend fun deleteAllArtists()

    @Query("Select * from popular_artists")
    suspend fun getArtists(): List<Artist>

}