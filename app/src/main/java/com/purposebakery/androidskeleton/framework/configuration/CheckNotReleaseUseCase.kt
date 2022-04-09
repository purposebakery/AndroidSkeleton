package com.purposebakery.androidskeleton.framework.configuration

class CheckNotReleaseUseCase {
    operator fun invoke() {
        forBuildTypes(release = {
            throw IllegalStateException("This is release. Shame on you.")
        })
    }
}