package com.purposebakery.androidskeleton.framework.dependency

import com.purposebakery.androidskeleton.framework.timber.ITimberFramework
import com.purposebakery.androidskeleton.framework.timber.TimberFramework
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class LoggingModule {
    @Provides
    fun provideTimberFramework(timberFramework: TimberFramework): ITimberFramework {
        return timberFramework
    }
}

