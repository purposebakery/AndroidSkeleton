package com.purposebakery.androidskeleton.features.pod.domain

import android.content.Context
import com.purposebakery.androidskeleton.BuildConfig
import com.purposebakery.androidskeleton.features.pod.data.contracts.IPodRemoteDataSource
import com.purposebakery.androidskeleton.features.pod.data.PodRemoteDataSource
import com.purposebakery.androidskeleton.features.pod.data.PodRepository
import com.purposebakery.androidskeleton.features.pod.data.contracts.IPodRepository
import com.purposebakery.androidskeleton.features.pod.data.contracts.PodService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PodModule {
    companion object {
        const val RETROFIT_API_NASA_GOV = "RETROFIT_API_NASA_GOV"
    }

    @Provides
    @Named(RETROFIT_API_NASA_GOV)
    fun provideRetrofitApiNasaGov() : Retrofit {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        return Retrofit.Builder()
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.nasa.gov/")
            .build()
    }

    @Provides
    fun providePodService(@Named(RETROFIT_API_NASA_GOV) retrofit: Retrofit) : PodService {
        return retrofit.create(PodService::class.java)
    }

    @Provides
    fun providePodRemoteDataSource(podRemoteDataSource : PodRemoteDataSource) : IPodRemoteDataSource {
        return podRemoteDataSource
    }

    @Provides
    @Singleton
    fun providePodRepository(podRepository : PodRepository) : IPodRepository {
        return podRepository
    }
}