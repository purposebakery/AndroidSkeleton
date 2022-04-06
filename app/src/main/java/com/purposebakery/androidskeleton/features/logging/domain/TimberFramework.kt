package com.purposebakery.androidskeleton.features.logging.domain

import timber.log.Timber
import javax.inject.Inject

interface ITimberFramework {
    fun initialize()
}

class TimberFramework @Inject constructor() : ITimberFramework {
    override fun initialize() {
        Timber.plant(Timber.DebugTree())
    }
}