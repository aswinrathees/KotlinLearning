package com.opensource.samples.activities.dagger2.utils

import android.util.Log
import javax.inject.Inject

class SmartPhone @Inject constructor(private val battery: Battery, private val simCard: SIMCard, private val memoryCard: MemoryCard) {

    init {
        battery.getPower()
        simCard.getConnection()
        memoryCard.getSpaceAvailability()
        Log.i("MYTAG", "SmartPhone Constructed")
    }

    fun makeCallWithRecording() {
        Log.i("MYTAG", "Calling.....")
    }
}