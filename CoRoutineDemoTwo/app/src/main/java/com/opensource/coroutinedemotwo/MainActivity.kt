package com.opensource.coroutinedemotwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Can use Dispatchers.IO as well...
        // But in that case need to show in Tag as
        // Toast will not work since its in main thread.
        CoroutineScope(Dispatchers.Main).launch {
            val stock1 = async { getStock1() }
            val stock2 = async { getStock2() }

            val total = stock1.await() + stock2.await()
            Toast.makeText(applicationContext, "Total is ${total}", Toast.LENGTH_SHORT).show()
        }
    }

    private suspend fun getStock1(): Int {
        delay(1000)
        return 5000
    }

    private suspend fun getStock2(): Int {
        delay(8000)
        return 2000
    }
}