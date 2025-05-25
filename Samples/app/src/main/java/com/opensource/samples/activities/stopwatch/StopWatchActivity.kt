package com.opensource.samples.activities.stopwatch

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.opensource.samples.databinding.ActivityStopWatchBinding

class StopWatchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStopWatchBinding
    private lateinit var serviceIntent: Intent

    private var isTimerStarted: Boolean = false
    private var time: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStopWatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        serviceIntent = Intent(applicationContext, StopWatchService::class.java)
        LocalBroadcastManager.getInstance(applicationContext).registerReceiver(
            updateTime,
            IntentFilter(StopWatchService.UPDATED_TIME)
        )

        binding.btnStartOrStop.setOnClickListener {
            startOrStopTimer()
        }

        binding.btnReset.setOnClickListener {
            resetTimer()
        }
    }

    private fun startOrStopTimer() {
        when (isTimerStarted) {
            true -> {
                stopService(serviceIntent)
                binding.btnStartOrStop.text = "Start"
                isTimerStarted = false
            }

            false -> {
                serviceIntent.putExtra(StopWatchService.CURRENT_TIME, time)
                startService(serviceIntent)
                binding.btnStartOrStop.text = "Stop"
                isTimerStarted = true
            }
        }
    }

    private fun resetTimer() {
        binding.btnStartOrStop.text = "Start"
        binding.tvTimer.text = "00:00:00"
        isTimerStarted = true
        stopService(serviceIntent)
    }

    private val updateTime: BroadcastReceiver = object : BroadcastReceiver() {

        override fun onReceive(p0: Context?, p1: Intent?) {
            time = p1?.getDoubleExtra(StopWatchService.UPDATED_TIME, 0.0) ?: 0.0
            binding.tvTimer.text = getFormattedTime(time.toInt())
        }
    }

    private fun getFormattedTime(time: Int): String {
        val hours = time / 3600
        val minutes = (time % 3600) / 60
        val remainingSeconds = time % 60

        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds)
    }
}