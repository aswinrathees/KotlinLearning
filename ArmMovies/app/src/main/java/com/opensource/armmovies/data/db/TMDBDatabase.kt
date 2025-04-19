package com.opensource.armmovies.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.opensource.armmovies.domain.dao.ArtistDao
import com.opensource.armmovies.domain.dao.MovieDao
import com.opensource.armmovies.domain.dao.TVShowDao
import com.opensource.armmovies.data.model.artist.Artist
import com.opensource.armmovies.data.model.movie.Movie
import com.opensource.armmovies.data.model.tvshow.TVShow

@Database(entities = [Movie::class, TVShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TVShowDao
    abstract fun artistDao(): ArtistDao

}