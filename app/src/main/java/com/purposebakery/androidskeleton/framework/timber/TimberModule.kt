package com.purposebakery.androidskeleton.framework.timber

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

