package com.opensource.workmanagerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.opensource.workmanagerdemo.utils.UploadWorker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.button)
        startButton.setOnClickListener {
            setOneTimeWorkRequest()
        }
    }

    private fun setOneTimeWorkRequest() {
        val uploadRequest: OneTimeWorkRequest =
            OneTimeWorkRequest.Builder(UploadWorker::class.java).build()
        WorkManager.getInstance(applicationContext).enqueue(uploadRequest)
    }
}