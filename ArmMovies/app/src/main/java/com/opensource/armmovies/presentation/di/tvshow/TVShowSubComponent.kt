package com.opensource.armmovies.presentation.di.tvshow

import com.opensource.armmovies.presentation.tvshow.TVShowActivity
import dagger.Subcomponent

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubComponent {

    fun inject(tvShowActivity: TVShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TVShowSubComponent
    }
}