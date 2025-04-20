package com.opensource.armmovies.presentation.di.artist

import com.opensource.armmovies.domain.usecases.GetArtistsUseCase
import com.opensource.armmovies.domain.usecases.UpdateArtistsUseCase
import com.opensource.armmovies.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}