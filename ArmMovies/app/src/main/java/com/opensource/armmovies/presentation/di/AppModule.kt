package com.opensource.armmovies.presentation.di

import android.content.Context
import com.opensource.armmovies.presentation.di.artist.ArtistSubComponent
import com.opensource.armmovies.presentation.di.movie.MovieSubComponent
import com.opensource.armmovies.presentation.di.tvshow.TVShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TVShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}