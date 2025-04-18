package com.opensource.samples.activities.dagger2.utils

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class LithiumIonModule {

    /*
    // Below implementation is for a class
    @Provides
    fun providesLithiumIonBattery(lithiumIon: LithiumIon): Battery {
        return lithiumIon
    }*/

    // Below implementation is for an abstract class
    @Binds
    abstract fun bindsLithiumIonBattery(lithiumIon: LithiumIon): Battery
}