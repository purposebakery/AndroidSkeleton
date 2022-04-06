package com.purposebakery.androidskeleton.features.pod.data

import com.purposebakery.androidskeleton.features.pod.domain.Pod
import retrofit2.http.GET
import retrofit2.http.Query

interface PodService {
    @GET("planetary/apod")
    suspend fun getPod(@Query("api_key") apiKey: String): Pod
}