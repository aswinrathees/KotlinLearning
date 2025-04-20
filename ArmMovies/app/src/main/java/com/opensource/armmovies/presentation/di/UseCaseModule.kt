package com.opensource.armmovies.presentation.di

import com.opensource.armmovies.domain.repoInterfaces.ArtistRepository
import com.opensource.armmovies.domain.repoInterfaces.MovieRepository
import com.opensource.armmovies.domain.repoInterfaces.TVShowRepository
import com.opensource.armmovies.domain.usecases.GetArtistsUseCase
import com.opensource.armmovies.domain.usecases.GetMoviesUseCase
import com.opensource.armmovies.domain.usecases.GetTVShowsUseCase
import com.opensource.armmovies.domain.usecases.UpdateArtistsUseCase
import com.opensource.armmovies.domain.usecases.UpdateMoviesUseCase
import com.opensource.armmovies.domain.usecases.UpdateTVShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTVShowUseCase(tvShowRepository: TVShowRepository): GetTVShowsUseCase {
        return GetTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTVShowUseCase(tvShowRepository: TVShowRepository): UpdateTVShowsUseCase {
        return UpdateTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }
}