package com.opensource.armmovies.presentation

import android.app.Application
import com.opensource.armmovies.BuildConfig
import com.opensource.armmovies.presentation.di.APIManagerModule
import com.opensource.armmovies.presentation.di.AppModule
import com.opensource.armmovies.presentation.di.RemoteDataModule
import com.opensource.armmovies.presentation.di.artist.ArtistSubComponent
import com.opensource.armmovies.presentation.di.interfaces.AppComponent
import com.opensource.armmovies.presentation.di.interfaces.DaggerAppComponent
import com.opensource.armmovies.presentation.di.interfaces.Injector
import com.opensource.armmovies.presentation.di.movie.MovieSubComponent
import com.opensource.armmovies.presentation.di.tvshow.TVShowSubComponent

class ArmApplication: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .aPIManagerModule(APIManagerModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTVShowSubComponent(): TVShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}