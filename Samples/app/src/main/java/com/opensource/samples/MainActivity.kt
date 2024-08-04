package com.opensource.samples

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.opensource.samples.activities.customizationSamples.BasicCustomizationActivity
import com.opensource.samples.activities.customizationSamples.CustomListViewActivity
import com.opensource.samples.activities.fragmentSamples.FragmentActivity
import com.opensource.samples.activities.fragmentSamples.fragments.contacts.ContactActivity
import com.opensource.samples.activities.intentSamples.IntentActivity
import com.opensource.samples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        binding.showIntentsSampleBtn.setOnClickListener {
            navigateToActivity(IntentActivity::class.java)
        }

        binding.showAdaptiveViewFragmentsSampleBtn.setOnClickListener {
            navigateToActivity(FragmentActivity::class.java)
        }

        binding.showContactsFragmentsSampleBtn.setOnClickListener {
            navigateToActivity(ContactActivity::class.java)
        }

        binding.showCustomizationsSampleBtn.setOnClickListener {
            navigateToActivity(BasicCustomizationActivity::class.java)
        }

        binding.showCustomListViewSampleBtn.setOnClickListener {
            navigateToActivity(CustomListViewActivity::class.java)
        }
    }

    private fun navigateToActivity(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }
}