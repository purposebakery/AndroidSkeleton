package com.purposebakery.androidskeleton.framework.timber

import timber.log.Timber
import javax.inject.Inject

interface IInitializeTimberUseCase {
    operator fun invoke()
}

class InitializeTimberUseCase @Inject constructor() : IInitializeTimberUseCase {
    override operator fun invoke()  {
        Timber.plant(Timber.DebugTree())
    }
}