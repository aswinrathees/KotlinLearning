package com.opensource.samples.activities.serviceSamples

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.opensource.samples.R
import com.opensource.samples.activities.serviceSamples.utils.StreamMusicHandler
import com.opensource.samples.activities.serviceSamples.utils.StreamMusicService
import com.opensource.samples.databinding.ActivityStreamMusicBinding

class StreamMusicActivity : AppCompatActivity(), StreamMusicHandler {

    private lateinit var  serviceIntent: Intent
    private var musicLink: String = "https://dl.dropboxusercontent.com/s/5ey5xwb7a5ylqps/games_of_thrones.mp3?dl=0"
    private var isMusicRunning: Boolean = false

    private lateinit var binding: ActivityStreamMusicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_stream_music)
        serviceIntent = Intent(this, StreamMusicService::class.java)

        initViews()
    }

    private fun initViews() {
        binding.ivMusicAction.setImageResource(R.drawable.ic_play_music)
        StreamMusicService.setContext(this)

        binding.ivMusicAction.setOnClickListener {
            if (StreamMusicService.isMusicPlaying) {
                stopMusic()
                binding.ivMusicAction.setImageResource(R.drawable.ic_play_music)
            } else {
                startMusic()
                binding.ivMusicAction.setImageResource(R.drawable.ic_pause_music)
            }
        }
    }

    private fun startMusic() {
        try {
            serviceIntent.putExtra("musicLink", musicLink)
            startService(serviceIntent)
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }

    private fun stopMusic() {
        try {
            stopService(serviceIntent)
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }

    override fun onMusicStopped() {
        binding.ivMusicAction.setImageResource(R.drawable.ic_play_music)
    }
}