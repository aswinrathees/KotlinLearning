package com.opensource.samples.activities.customizationSamples

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.opensource.samples.R
import com.opensource.samples.activities.customizationSamples.helpers.ViewUtilities

class CustomActionBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_action_bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            supportActionBar?.let {
                val actionBar: ActionBar = it
                actionBar.setIcon(R.drawable.ic_browser)
                actionBar.title= "Custom Action Bar"
                actionBar.setDisplayUseLogoEnabled(true)
                actionBar.setDisplayShowHomeEnabled(true)
                actionBar.setDisplayHomeAsUpEnabled(true)
            }
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.refresh -> ViewUtilities.showToast(this, "Refresh clicked")
            R.id.download -> ViewUtilities.showToast(this, "Download clicked")
            R.id.upload -> ViewUtilities.showToast(this, "Upload clicked")
        }
        return super.onOptionsItemSelected(item)
    }
}