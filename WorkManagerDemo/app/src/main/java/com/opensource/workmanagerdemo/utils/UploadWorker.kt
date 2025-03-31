package com.opensource.workmanagerdemo.utils

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlin.Exception

class UploadWorker(
    context: Context, workerParams: WorkerParameters
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        return try {
            for (index: Int in 1..60) {
                Log.i("WorkManagerDemo", "Uploading $index")
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}