package com.purposebakery.androidskeleton.core

import android.app.Application
import com.purposebakery.androidskeleton.features.logging.domain.ITimberFramework
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AndroidSkeletonApplication : Application() {

    @Inject
    lateinit var timberFramework: ITimberFramework

    override fun onCreate() {
        super.onCreate()

        timberFramework.initialize()
    }
}