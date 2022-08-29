package com.opensource.notifications

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.NotificationCompat

class NotificationActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        textView = findViewById(R.id.textView)
        receiveInput()
    }

    private fun receiveInput() {
        val KEY_REPLY = "key_reply"
        val intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if(remoteInput!=null) {
            val inputString = remoteInput.getCharSequence(KEY_REPLY).toString()
            textView.text = inputString

            val notificationChannelId: String = "com.opensource.notifications"
            val notificationId = 1

            val repliedNotification = NotificationCompat.Builder(this,notificationChannelId)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentText("Reply received")
                .build()

            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(notificationId,repliedNotification)
        }
    }
}