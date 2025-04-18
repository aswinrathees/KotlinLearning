package com.opensource.samples.activities.dagger2.utils

import com.opensource.samples.activities.dagger2.Dagger2Activity
import dagger.Component

@Component(modules = [MemoryCardModule::class, LithiumIonModule::class])
interface SmartPhoneComponent {

    //fun getSmartPhone(): SmartPhone

    fun inject(dagger2Activity: Dagger2Activity)
}