package com.opensource.armmovies.presentation.di

import android.content.Context
import androidx.room.Room
import com.opensource.armmovies.data.db.TMDBDatabase
import com.opensource.armmovies.domain.dao.ArtistDao
import com.opensource.armmovies.domain.dao.MovieDao
import com.opensource.armmovies.domain.dao.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @Singleton
    @Provides
    fun provideMovieDB(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbClient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTVShowDao(tmdbDatabase: TMDBDatabase): TVShowDao {
        return tmdbDatabase.tvDao()
    }

}