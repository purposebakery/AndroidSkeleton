package com.purposebakery.androidskeleton.features.pod.data.contracts

import com.purposebakery.androidskeleton.features.pod.domain.Pod
import retrofit2.http.GET
import retrofit2.http.Query

interface IPodRemoteDataSource {
    suspend fun requestPod(): Pod
}

interface PodService {
    @GET("planetary/apod")
    suspend fun getPod(@Query("api_key") apiKey : String) : Pod
}