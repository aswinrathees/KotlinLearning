package com.opensource.armmovies.presentation.di

import com.opensource.armmovies.data.repository.artist.ArtistCacheDataSource
import com.opensource.armmovies.data.repository.artist.ArtistLocalDataSource
import com.opensource.armmovies.data.repository.artist.ArtistRemoteDataSource
import com.opensource.armmovies.data.repository.artist.ArtistRepositoryImpl
import com.opensource.armmovies.data.repository.movie.MovieCacheDataSource
import com.opensource.armmovies.data.repository.movie.MovieLocalDataSource
import com.opensource.armmovies.data.repository.movie.MovieRemoteDataSource
import com.opensource.armmovies.data.repository.movie.MovieRepositoryImpl
import com.opensource.armmovies.data.repository.tvshow.TVShowCacheDataSource
import com.opensource.armmovies.data.repository.tvshow.TVShowLocalDataSource
import com.opensource.armmovies.data.repository.tvshow.TVShowRemoteDataStore
import com.opensource.armmovies.data.repository.tvshow.TVShowRepositoryImpl
import com.opensource.armmovies.domain.repoInterfaces.ArtistRepository
import com.opensource.armmovies.domain.repoInterfaces.MovieRepository
import com.opensource.armmovies.domain.repoInterfaces.TVShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTVShowRepository(
        tvShowRemoteDataSource: TVShowRemoteDataStore,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource
    ): TVShowRepository {
        return TVShowRepositoryImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }
}