package com.purposebakery.androidskeleton.framework.configuration

import com.purposebakery.androidskeleton.BuildConfig

@Suppress("unused")
enum class BuildType {
    DEBUG, RELEASE
}

fun forBuildTypes(
    debug: (() -> Unit)? = null,
    release: (() -> Unit)? = null
) {
    if (BuildConfig.BUILD_TYPE_ENUM == null) {
        throw IllegalStateException("Build type ${BuildConfig.BUILD_TYPE} not supported.")
    } else {
        when (BuildConfig.BUILD_TYPE_ENUM) {
            BuildType.DEBUG -> debug?.invoke()
            BuildType.RELEASE -> release?.invoke()
        }
    }
}

fun checkNotRelease() {
    forBuildTypes(release = {
        throw IllegalStateException("This is release. Shame on you.")
    })
}