package com.purposebakery.androidskeleton.features.pod.ui

import com.purposebakery.androidskeleton.core.UiState

data class PodUiState (
    var userMessage : String? = null,
    var loadButtonText : String = "",
    val podLoading : Boolean = false,
    var podUrl : String? = null,
    var podExplanation : String? = null,
    var podTitle : String? = null,
    var podDate : String? = null,
) : UiState