package com.opensource.samples.activities.dagger2.utils

import android.util.Log
import javax.inject.Inject

class LithiumIon @Inject constructor() : Battery {

    override fun getPower() {
        Log.i("MYTAG", "LithiumIon Battery.....")
    }
}