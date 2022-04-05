package com.purposebakery.androidskeleton.features.pod.data

import com.purposebakery.androidskeleton.BuildConfig
import com.purposebakery.androidskeleton.features.pod.data.contracts.IPodRemoteDataSource
import com.purposebakery.androidskeleton.features.pod.data.contracts.PodService
import com.purposebakery.androidskeleton.features.pod.domain.Pod
import java.lang.Exception
import javax.inject.Inject

class PodRemoteDataSource @Inject constructor(
    private val podService: PodService
) : IPodRemoteDataSource {

    override suspend fun requestPod():  Pod {
        return podService.getPod(BuildConfig.API_KEY_DATA_GOV)
    }
}
