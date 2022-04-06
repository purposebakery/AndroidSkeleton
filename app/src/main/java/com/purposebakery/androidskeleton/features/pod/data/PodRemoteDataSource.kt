package com.purposebakery.androidskeleton.features.pod.data

import com.purposebakery.androidskeleton.BuildConfig
import com.purposebakery.androidskeleton.features.pod.domain.Pod
import javax.inject.Inject

interface IPodRemoteDataSource {
    suspend fun requestPod(): Pod
}

class PodRemoteDataSource @Inject constructor(
    private val podService: PodService
) : IPodRemoteDataSource {

    override suspend fun requestPod(): Pod {
        return podService.getPod(BuildConfig.API_KEY_DATA_GOV)
    }
}
