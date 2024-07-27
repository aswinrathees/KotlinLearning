package com.opensource.samples.activities.fragmentSamples

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.opensource.samples.R
import com.opensource.samples.activities.fragmentSamples.fragments.ItemSelected

class FragmentActivity : AppCompatActivity(), ItemSelected {

    companion object {
        var index = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment)
    }

    override fun onItemSelected(index: Int) {
        Log.d("FragmentActivity", "onItemSelected: $index")
        FragmentActivity.index = index
        Log.d("FragmentActivity", "onItemSelected: ${FragmentActivity.index}")
    }
}