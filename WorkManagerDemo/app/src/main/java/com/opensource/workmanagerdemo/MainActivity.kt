package com.opensource.workmanagerdemo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.opensource.workmanagerdemo.utils.UploadWorker

class MainActivity : AppCompatActivity() {
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                setOneTimeWorkRequest()
            }
        }

        tvStatus = findViewById(R.id.textView)
    }

    private fun setOneTimeWorkRequest() {
        val workManager =  WorkManager.getInstance(this)
        val constraints =  Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val uploadWorkRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .setConstraints(constraints)
            .build()

        //Note: WorkerChaining can be done with workManager.beginWith(worker1).then(worker2). etc .enqueue()
        //Note: Parallel work can done with creating an mutable list of workers and adding it in beginWith()
        //Note: Periodic work can be done with PeriodicWorkRequest.Builder() which takes an argument for repeatInterval and the TimeUnit

        workManager.enqueue(uploadWorkRequest)
        workManager.getWorkInfoByIdLiveData(uploadWorkRequest.id).observe(this) {
            tvStatus.text = it.state.name
        }
    }
}