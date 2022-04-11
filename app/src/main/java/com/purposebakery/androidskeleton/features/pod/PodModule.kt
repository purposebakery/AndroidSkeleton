package com.purposebakery.androidskeleton.features.pod

import android.annotation.SuppressLint
import com.purposebakery.androidskeleton.features.pod.data.*
import com.purposebakery.androidskeleton.framework.configuration.forBuildTypes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.inject.Named
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@InstallIn(SingletonComponent::class)
@Module
class PodModule {
    companion object {
        const val RETROFIT_API_NASA_GOV = "RETROFIT_API_NASA_GOV"
    }

    @Provides
    @Named(RETROFIT_API_NASA_GOV)
    fun provideRetrofitApiNasaGov(): Retrofit {
        val clientBuilder = OkHttpClient.Builder()
        forBuildTypes (debug = {

            val trustManager = @SuppressLint("CustomX509TrustManager")
            object : X509TrustManager {
                @SuppressLint("TrustAllX509TrustManager")
                override fun checkClientTrusted(p0: Array<out X509Certificate>?, p1: String?) {
                    // no-op
                }

                @SuppressLint("TrustAllX509TrustManager")
                override fun checkServerTrusted(p0: Array<out X509Certificate>?, p1: String?) {
                    // no-op
                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            }

            val sc: SSLContext = SSLContext.getInstance("TLS")
            sc.init(null, arrayOf(trustManager), SecureRandom())

            clientBuilder.sslSocketFactory(sc.socketFactory, trustManager)
        })

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
    fun providePodService(@Named(RETROFIT_API_NASA_GOV) retrofit: Retrofit): PodService {
        return retrofit.create(PodService::class.java)
    }

    @Provides
    fun providePodRemoteDataSource(podRemoteDataSource: PodRemoteDataSource): IPodRemoteDataSource {
        return podRemoteDataSource
    }

    @Provides
    @Singleton
    fun providePodRepository(podRepository: PodRepository): IPodRepository {
        return podRepository
    }
}