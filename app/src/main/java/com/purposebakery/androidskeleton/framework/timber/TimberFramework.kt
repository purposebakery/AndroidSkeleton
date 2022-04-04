package com.purposebakery.androidskeleton.framework.timber

import timber.log.Timber
import javax.inject.Inject

class TimberFramework @Inject constructor(): ITimberFramework {
    override fun initialize() {
        Timber.plant(Timber.DebugTree())
    }
}