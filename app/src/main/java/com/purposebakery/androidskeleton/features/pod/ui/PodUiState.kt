package com.purposebakery.androidskeleton.features.pod.ui

import com.purposebakery.androidskeleton.core.UiState

data class PodUiState (
    var userMessage : String? = null,
    var loadButtonText : String = "",
    var podUrl : String? = null
) : UiState