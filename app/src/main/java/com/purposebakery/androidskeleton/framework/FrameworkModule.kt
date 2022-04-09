package com.purposebakery.androidskeleton.framework

import com.purposebakery.androidskeleton.framework.timber.IInitializeTimberUseCase
import com.purposebakery.androidskeleton.framework.timber.InitializeTimberUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class FrameworkModule {
    @Provides
    fun provideInitializeTimberUseCase(initializeTimberUseCase: InitializeTimberUseCase): IInitializeTimberUseCase {
        return initializeTimberUseCase
    }
}

