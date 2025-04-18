package com.opensource.samples.activities.dagger2.utils

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor() {

    fun getServiceProvider() {
        Log.i("MYTAG", "ServiceProvider.....")
    }
}