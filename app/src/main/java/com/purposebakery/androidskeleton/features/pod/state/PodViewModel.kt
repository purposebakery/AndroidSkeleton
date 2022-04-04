package com.purposebakery.androidskeleton.features.pod.state

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.purposebakery.androidskeleton.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PodViewModel @Inject constructor(
    private val app: Application
) : AndroidViewModel(app) {

    val loadButtonTextLiveData: LiveData<String> get() = loadButtonText
    private val loadButtonText = MutableLiveData<String>()

    init {
        loadButtonText.value = app.getString(R.string.pod_load_button)
    }

    fun onPodButtonPressed() {
        loadButtonText.value = app.getString(R.string.pod_reload_button)
        Log.d("TAG", "Jo!")
    }
}