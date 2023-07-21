package com.opensource.workmanagerdemo.utils

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class UploadWorker(
    context: Context, parameters: WorkerParameters,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {
    override fun doWork(): Result {
        try {
            for (index: Int in 1..60) {
                Log.i("WorkManagerDemo", "Uploading $index")
            }
            return Result.success()
        } catch (e:Exception) {
            return Result.failure()
        }
    }
}