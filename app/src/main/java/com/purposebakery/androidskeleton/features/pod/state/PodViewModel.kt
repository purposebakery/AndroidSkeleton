package com.purposebakery.androidskeleton.features.pod.state

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PodViewModel @Inject constructor(
    app: Application
): AndroidViewModel(app) {
    fun onPodButtonPressed() {
        Log.d("TAG", "Jo!")
    }
}