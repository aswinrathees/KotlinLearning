package com.opensource.armmovies.presentation.di

import com.opensource.armmovies.data.api.ApiService
import com.opensource.armmovies.data.repository.artist.ArtistRemoteDataSource
import com.opensource.armmovies.data.repository.artist.ArtistRemoteDataSourceImpl
import com.opensource.armmovies.data.repository.movie.MovieRemoteDataSource
import com.opensource.armmovies.data.repository.movie.MovieRemoteDataSourceImpl
import com.opensource.armmovies.data.repository.tvshow.TVShowRemoteDataStore
import com.opensource.armmovies.data.repository.tvshow.TVShowRemoteDataStoreImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(apiService: ApiService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(apiService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTVShowRemoteDataSource(apiService: ApiService): TVShowRemoteDataStore {
        return TVShowRemoteDataStoreImpl(apiService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(apiService: ApiService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(apiService, apiKey)
    }
}