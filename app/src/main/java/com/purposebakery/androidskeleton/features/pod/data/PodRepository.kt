package com.purposebakery.androidskeleton.features.pod.data

import com.purposebakery.androidskeleton.features.pod.domain.Pod
import javax.inject.Inject

interface IPodRepository {
    suspend fun getPod(): Pod
}

class PodRepository @Inject constructor(
    private val podRemoteDataSource: PodRemoteDataSource
) : IPodRepository {
    override suspend fun getPod(): Pod {
        return podRemoteDataSource.requestPod()
    }
}