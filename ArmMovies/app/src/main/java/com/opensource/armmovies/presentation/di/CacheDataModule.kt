package com.opensource.armmovies.presentation.di

import com.opensource.armmovies.data.repository.artist.ArtistCacheDataSource
import com.opensource.armmovies.data.repository.artist.ArtistCacheDataSourceImpl
import com.opensource.armmovies.data.repository.movie.MovieCacheDataSource
import com.opensource.armmovies.data.repository.movie.MovieCacheDataSourceImpl
import com.opensource.armmovies.data.repository.tvshow.TVShowCacheDataSource
import com.opensource.armmovies.data.repository.tvshow.TVShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTVShowCacheDataSource(): TVShowCacheDataSource {
        return TVShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}