package com.opensource.armmovies.presentation.di.interfaces

import com.opensource.armmovies.presentation.di.APIManagerModule
import com.opensource.armmovies.presentation.di.AppModule
import com.opensource.armmovies.presentation.di.CacheDataModule
import com.opensource.armmovies.presentation.di.DBModule
import com.opensource.armmovies.presentation.di.LocalDataModule
import com.opensource.armmovies.presentation.di.RemoteDataModule
import com.opensource.armmovies.presentation.di.RepositoryModule
import com.opensource.armmovies.presentation.di.UseCaseModule
import com.opensource.armmovies.presentation.di.artist.ArtistSubComponent
import com.opensource.armmovies.presentation.di.movie.MovieSubComponent
import com.opensource.armmovies.presentation.di.tvshow.TVShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        APIManagerModule::class,
        DBModule::class,
        CacheDataModule::class,
        LocalDataModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory

    fun tvShowSubComponent(): TVShowSubComponent.Factory

    fun artistSubComponent(): ArtistSubComponent.Factory

}