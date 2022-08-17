package com.opensource.coroutinedemoone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClick: Button = findViewById(R.id.btnCount)
        val buttonDownloadUserData: Button = findViewById(R.id.btnDownloadUserData)
        val textView: TextView = findViewById(R.id.tvCount)
        var updateTextView: TextView = findViewById(R.id.tvUserMessage)

        buttonClick.setOnClickListener {
            textView.text = count++.toString()
        }

        buttonDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData(updateTextView)
            }
        }
    }

    private suspend fun downloadUserData(updateTextView: TextView) {
        withContext(Dispatchers.Main) {
            for (i in 1..10000) {
                Log.i("CoroutineTag", "Downloading user $i in ${Thread.currentThread().name}")
                updateTextView.text = "Downloading user $i in ${Thread.currentThread().name}"
                delay(1000)
            }
        }
    }
}