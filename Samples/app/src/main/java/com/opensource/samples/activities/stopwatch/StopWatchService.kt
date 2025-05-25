package com.opensource.samples.activities.stopwatch

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import java.util.Timer
import java.util.TimerTask

class StopWatchService : Service() {

    private val timer = Timer()

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val time = intent?.getDoubleExtra(CURRENT_TIME, 0.0)
        timer.schedule(StopWatchTimerTask(time!!), 0, 1000)
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        timer.cancel()

        super.onDestroy()
    }

    companion object {
        const val CURRENT_TIME = "currentTime"
        const val UPDATED_TIME = "updatedTime"
    }

    private inner class StopWatchTimerTask(private var time: Double) : TimerTask() {

        override fun run() {
            time++
            LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(Intent(UPDATED_TIME).apply {
                putExtra(UPDATED_TIME, time)
            })
        }
    }
}