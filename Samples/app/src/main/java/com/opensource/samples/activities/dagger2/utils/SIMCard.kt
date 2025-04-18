package com.opensource.samples.activities.dagger2.utils

import android.util.Log
import javax.inject.Inject

class SIMCard @Inject constructor(private val serviceProvider: ServiceProvider) {

    fun getConnection() {
        Log.i("MYTAG", "SIMCard.....")
        serviceProvider.getServiceProvider()
    }
}