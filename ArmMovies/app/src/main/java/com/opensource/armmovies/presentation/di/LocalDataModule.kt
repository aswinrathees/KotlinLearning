package com.opensource.armmovies.presentation.di

import com.opensource.armmovies.data.repository.artist.ArtistLocalDataSource
import com.opensource.armmovies.data.repository.artist.ArtistLocalDataSourceImpl
import com.opensource.armmovies.data.repository.movie.MovieLocalDataSource
import com.opensource.armmovies.data.repository.movie.MovieLocalDataSourceImpl
import com.opensource.armmovies.data.repository.tvshow.TVShowLocalDataSource
import com.opensource.armmovies.data.repository.tvshow.TVShowLocalDataStoreImpl
import com.opensource.armmovies.domain.dao.ArtistDao
import com.opensource.armmovies.domain.dao.MovieDao
import com.opensource.armmovies.domain.dao.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTVShowLocalDataSource(tvShowDao: TVShowDao): TVShowLocalDataSource {
        return TVShowLocalDataStoreImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}