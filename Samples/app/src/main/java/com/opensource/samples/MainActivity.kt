package com.opensource.samples

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.opensource.samples.activities.appWidgets.AppWidgetsActivity
import com.opensource.samples.activities.customizationSamples.BasicCustomizationActivity
import com.opensource.samples.activities.customizationSamples.CustomActionBarActivity
import com.opensource.samples.activities.customizationSamples.CustomListViewActivity
import com.opensource.samples.activities.customizationSamples.helpers.ViewUtilities
import com.opensource.samples.activities.dagger2.Dagger2Activity
import com.opensource.samples.activities.fragmentSamples.FragmentActivity
import com.opensource.samples.activities.fragmentSamples.fragments.contacts.ContactActivity
import com.opensource.samples.activities.intentSamples.IntentActivity
import com.opensource.samples.activities.permissionSamples.PermissionsActivity
import com.opensource.samples.activities.rssfeedSamples.RssFeedActivity
import com.opensource.samples.activities.serviceSamples.StreamMusicActivity
import com.opensource.samples.activities.smsSamples.SMSActivity
import com.opensource.samples.activities.sqliteSamples.SQLiteActivity
import com.opensource.samples.activities.unitTests.UnitTestsActivity
import com.opensource.samples.activities.viewBinding.ViewBindingActivity
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
            ViewUtilities.showToast(this, "This is basic implementation")
            navigateToActivity(BasicCustomizationActivity::class.java)
        }

        binding.showCustomListViewSampleBtn.setOnClickListener {
            navigateToActivity(CustomListViewActivity::class.java)
        }

        binding.showCustomActionBarSampleBtn.setOnClickListener {
            navigateToActivity(CustomActionBarActivity::class.java)
        }

        binding.showSQLiteSampleBtn.setOnClickListener {
            navigateToActivity(SQLiteActivity::class.java)
        }

        binding.showPermissionSampleBtn.setOnClickListener {
            navigateToActivity(PermissionsActivity::class.java)
        }

        binding.showRssFeedSampleBtn.setOnClickListener {
            navigateToActivity(RssFeedActivity::class.java)
        }

        binding.showSendSMSSampleBtn.setOnClickListener {
            navigateToActivity(SMSActivity::class.java)
        }

        binding.showMusicServiceSampleBtn.setOnClickListener {
            navigateToActivity(StreamMusicActivity::class.java)
        }

        binding.showAppWidgetsSampleBtn.setOnClickListener {
            navigateToActivity(AppWidgetsActivity::class.java)
        }

        binding.showGoogleMapsSampleBtn.setOnClickListener {
            navigateToActivity(MapsActivity::class.java)
        }

        binding.showDagger2SampleBtn.setOnClickListener {
            navigateToActivity(Dagger2Activity::class.java)
        }

        binding.showUnitTestsBtn.setOnClickListener {
            navigateToActivity(UnitTestsActivity::class.java)
        }

        binding.showViewBindingBtn.setOnClickListener {
            navigateToActivity(ViewBindingActivity::class.java)
        }
    }

    private fun navigateToActivity(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }
}