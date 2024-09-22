package com.opensource.armcontacts

import android.app.Application
import android.util.Log
import com.backendless.Backendless

class ArmContactsApplication: Application() {

    private val applicationID = "F144F1A4-B8FE-426C-871B-76244AC6E621"
    private val secretKey = "0158353F-CB52-45B8-A983-3FDB61436174"
    private val serverUrl = "https://api.backendless.com"

    override fun onCreate() {
        super.onCreate()
        Log.d("ArmContactsApplication", "onCreate")
        Backendless.setUrl(serverUrl)
        Backendless.initApp( this, applicationID, secretKey)
    }
}