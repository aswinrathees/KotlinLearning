package com.opensource.armmovies.presentation.di.interfaces

import com.opensource.armmovies.presentation.di.artist.ArtistSubComponent
import com.opensource.armmovies.presentation.di.movie.MovieSubComponent
import com.opensource.armmovies.presentation.di.tvshow.TVShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTVShowSubComponent(): TVShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}