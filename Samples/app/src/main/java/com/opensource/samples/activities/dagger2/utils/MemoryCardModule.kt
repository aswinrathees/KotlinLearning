package com.opensource.samples.activities.dagger2.utils

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule (private val memorySize: Int) {

    @Provides
    fun providesMemoryCard(): MemoryCard {
        Log.i("MYTAG", "Size of the memory is $memorySize")
        return MemoryCard()
    }
}