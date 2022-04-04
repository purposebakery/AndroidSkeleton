package com.purposebakery.androidskeleton.features.pod.state

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.purposebakery.androidskeleton.R
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PodViewModel @Inject constructor(
    private val app: Application
) : AndroidViewModel(app) {

    val loadButtonText: LiveData<String> get() = loadButtonTextMutable
    private val loadButtonTextMutable = MutableLiveData<String>()

    init {
        loadButtonTextMutable.value = app.getString(R.string.pod_load_button)
    }

    fun onPodButtonPressed() {
        loadButtonTextMutable.value = app.getString(R.string.pod_reload_button)
        Timber.d("Load Picture")
    }
}