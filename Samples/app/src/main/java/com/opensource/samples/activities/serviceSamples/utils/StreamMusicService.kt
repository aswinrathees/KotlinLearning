package com.opensource.samples.activities.serviceSamples.utils

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast
import com.opensource.samples.activities.serviceSamples.StreamMusicActivity

interface StreamMusicHandler {
    fun onMusicStopped()
}

class StreamMusicService : Service(), MediaPlayer.OnCompletionListener,
    MediaPlayer.OnPreparedListener,
    MediaPlayer.OnErrorListener {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var musicLink: String
    private lateinit var streamMusicHandler: StreamMusicHandler

    companion object {
        var isMusicPlaying: Boolean = false
        var activity: StreamMusicActivity? = null

        fun setContext(activity: StreamMusicActivity) {
            this.activity = activity
        }
    }

    override fun onCreate() {
        super.onCreate()

        mediaPlayer = MediaPlayer()
        mediaPlayer.setOnCompletionListener(this)
        mediaPlayer.setOnPreparedListener(this)
        mediaPlayer.setOnErrorListener(this)

        //Todo add listeners
        /*mediaPlayer.setOnSeekCompleteListener(this)
        mediaPlayer.setOnInfoListener(this)
        mediaPlayer.setOnBufferingUpdateListener(this)*/
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        musicLink = intent?.getStringExtra("musicLink") ?: ""
        mediaPlayer.reset()

        streamMusicHandler = activity as StreamMusicHandler

        if (!mediaPlayer.isPlaying) {
            try {
                mediaPlayer.setDataSource(musicLink)
                mediaPlayer.prepareAsync()
            } catch (e: Exception) {
                Toast.makeText(this, "Error setting data source ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()

        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }

        isMusicPlaying = false
        mediaPlayer.release()
    }

    override fun onCompletion(mp: MediaPlayer?) {
        mp?.let {
            if (it.isPlaying) {
                it.stop()
            }
        }

        isMusicPlaying = false
        streamMusicHandler.onMusicStopped()

        stopSelf()
    }

    override fun onPrepared(mp: MediaPlayer?) {
        if (!mp?.isPlaying!!) {
            mp.start()
            isMusicPlaying = true
        }
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        isMusicPlaying = false

        when (what) {
            MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK -> {
                Toast.makeText(this, "MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK", Toast.LENGTH_LONG).show()
            }

            MediaPlayer.MEDIA_ERROR_SERVER_DIED -> {
                Toast.makeText(this, "MEDIA_ERROR_SERVER_DIED", Toast.LENGTH_LONG).show()
            }

            MediaPlayer.MEDIA_ERROR_UNKNOWN -> {
                Toast.makeText(this, "MEDIA_ERROR_UNKNOWN", Toast.LENGTH_LONG).show()
            }
        }

        return false
    }

    // Todo
    /*override fun onInfo(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSeekComplete(mp: MediaPlayer?) {
        TODO("Not yet implemented")
    }

    override fun onBufferingUpdate(mp: MediaPlayer?, percent: Int) {
        TODO("Not yet implemented")
    }*/

}