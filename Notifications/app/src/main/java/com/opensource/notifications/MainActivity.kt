package com.opensource.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    private val notificationChannelId: String = "com.opensource.notifications"
    private var notificationManager: NotificationManager? = null
    private var KEY_REPLY = "key_reply"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        createNotificationChannel(notificationChannelId, "Notification", "Notification Demo")
        val notificationButton = findViewById<Button>(R.id.button)
        notificationButton.setOnClickListener {
            displayNotification()
        }
    }

    private fun displayNotification() {
        val notificationId = 1
        val tapResultIntent = Intent(this, NotificationActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            tapResultIntent,
            PendingIntent.FLAG_MUTABLE
        )

        //Reply action
        val remoteInput: androidx.core.app.RemoteInput =
            androidx.core.app.RemoteInput.Builder(KEY_REPLY).run {
                setLabel("Enter your reply")
                build()
            }

        val replyAction: NotificationCompat.Action = NotificationCompat.Action.Builder(
            0,
            "Reply",
            pendingIntent
        ).addRemoteInput(remoteInput).build()

        //Action
        val actionResultIntent = Intent(this, DetailsActivity::class.java)
        val actionIntent: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            actionResultIntent,
            PendingIntent.FLAG_MUTABLE
        )
        val action: NotificationCompat.Action =
            NotificationCompat.Action.Builder(0, "Details", actionIntent).build()

        //Settings
        val settingsResultIntent = Intent(this, SettingsActivity::class.java)
        val settingsIntent: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            settingsResultIntent,
            PendingIntent.FLAG_MUTABLE
        )
        val settings: NotificationCompat.Action =
            NotificationCompat.Action.Builder(0, "Settings", settingsIntent).build()

        val notification = NotificationCompat.Builder(this, notificationChannelId)
            .setContentTitle("Notification Title")
            .setContentText("Notification Demo")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            //.setContentIntent(pendingIntent)
            .addAction(action)
            .addAction(settings)
            .addAction(replyAction)
            .build()
        notificationManager?.notify(notificationId, notification)
    }

    private fun createNotificationChannel(id: String, name: String, channelDescription: String) {
//        Condition check if your minimum SDK version is less than 5
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(id, name, importance).apply {
            description = channelDescription
        }
        notificationManager?.createNotificationChannel(channel)
//            channel.description = channelDescription
//        }
    }
}