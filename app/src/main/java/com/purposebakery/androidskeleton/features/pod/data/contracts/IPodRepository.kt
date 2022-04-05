package com.purposebakery.androidskeleton.features.pod.data.contracts

import com.purposebakery.androidskeleton.features.pod.domain.Pod

interface IPodRepository {
    suspend fun getPod() : Pod
}