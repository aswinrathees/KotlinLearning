package com.opensource.samples.activities.dagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.opensource.samples.R
import com.opensource.samples.activities.dagger2.utils.DaggerSmartPhoneComponent
import com.opensource.samples.activities.dagger2.utils.MemoryCard
import com.opensource.samples.activities.dagger2.utils.MemoryCardModule
import com.opensource.samples.activities.dagger2.utils.SmartPhone
import javax.inject.Inject

class Dagger2Activity : AppCompatActivity() {

    @Inject
    lateinit var smartPhone: SmartPhone

    @Inject
    lateinit var memoryCard: MemoryCard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dagger2)

        // Method 1
        //DaggerSmartPhoneComponent.create().getSmartPhone().makeCallWithRecording()

        // Method 2 - Field Inject handling
        //DaggerSmartPhoneComponent.create().inject(this)
        //smartPhone.makeCallWithRecording()
        //memoryCard.getSpaceAvailability()

        // Method 3 - With State of a module
        DaggerSmartPhoneComponent.builder()
            .memoryCardModule(MemoryCardModule(1000))
            .build().inject(this)
    }
}