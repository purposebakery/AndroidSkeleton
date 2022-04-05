package com.purposebakery.androidskeleton.features.pod.state

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.purposebakery.androidskeleton.R
import com.purposebakery.androidskeleton.features.pod.data.contracts.IPodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PodViewModel @Inject constructor(
    private val app: Application,
    private val podRepository: IPodRepository
) : AndroidViewModel(app) {

    val loadButtonText: LiveData<String> get() = loadButtonTextMutable
    val podUrl: LiveData<String> get() = podUrlMutable

    private val loadButtonTextMutable = MutableLiveData<String>()
    private val podUrlMutable = MutableLiveData<String>()

    init {
        loadButtonTextMutable.value = app.getString(R.string.pod_load_button)
    }

    fun onPodButtonPressed() {
        loadButtonTextMutable.value = app.getString(R.string.pod_reload_button)
        viewModelScope.launch {
            try {
                podUrlMutable.value = podRepository.getPod().url
            } catch (e: Exception) {
                Timber.e(e)
                // TODO handle loading errors
            }
        }
    }
}