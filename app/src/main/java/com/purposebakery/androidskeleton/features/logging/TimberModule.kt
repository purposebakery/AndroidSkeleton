package com.purposebakery.androidskeleton.features.logging

import com.purposebakery.androidskeleton.features.logging.domain.ITimberFramework
import com.purposebakery.androidskeleton.features.logging.domain.TimberFramework
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class TimberModule {
    @Provides
    fun provideTimberFramework(timberFramework: TimberFramework): ITimberFramework {
        return timberFramework
    }
}

