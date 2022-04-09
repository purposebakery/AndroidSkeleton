package com.purposebakery.androidskeleton.core

import android.app.Application
import com.purposebakery.androidskeleton.framework.timber.IInitializeTimberUseCase
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AndroidSkeletonApplication : Application() {

    @Inject
    lateinit var initializeTimberUseCase: IInitializeTimberUseCase

    override fun onCreate() {
        super.onCreate()

        initializeTimberUseCase()
    }
}