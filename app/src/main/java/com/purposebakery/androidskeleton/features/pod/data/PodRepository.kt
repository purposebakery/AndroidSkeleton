package com.purposebakery.androidskeleton.features.pod.data

import com.purposebakery.androidskeleton.features.pod.data.contracts.IPodRepository
import com.purposebakery.androidskeleton.features.pod.domain.Pod
import javax.inject.Inject

class PodRepository @Inject constructor(
    private val podRemoteDataSource: PodRemoteDataSource
) : IPodRepository {
    override suspend fun getPod() : Pod {
        return podRemoteDataSource.requestPod()
    }
}