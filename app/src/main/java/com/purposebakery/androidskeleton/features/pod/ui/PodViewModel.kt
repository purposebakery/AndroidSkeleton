package com.purposebakery.androidskeleton.features.pod.ui

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.purposebakery.androidskeleton.R
import com.purposebakery.androidskeleton.core.BaseUiStateViewModel
import com.purposebakery.androidskeleton.features.pod.data.IPodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PodViewModel @Inject constructor(
    private val app: Application,
    private val podRepository: IPodRepository
) : BaseUiStateViewModel<PodUiState>(app) {

    private val _uiState = MutableStateFlow(PodUiState())
    override val uiState = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(loadButtonText = app.getString(R.string.pod_load_button))
        }
    }

    fun onPodButtonPressed() {
        setLoadButtonWithReloadText()
        loadPod()
    }

    private fun setLoadButtonWithReloadText() {
        _uiState.update {
            it.copy(loadButtonText = app.getString(R.string.pod_reload_button))
        }
    }

    private fun loadPod() {
        viewModelScope.launch {
            try {
                _uiState.update {
                    val pod = podRepository.getPod()
                    it.copy(
                        podUrl = pod.url,
                        podExplanation = pod.explanation,
                        podTitle = pod.title,
                        podDate = pod.date
                    )
                }
            } catch (e: Exception) {
                Timber.e(e)
                _uiState.update {
                    it.copy(userMessage = app.getString(R.string.pod_load_error))
                }
            }
        }
    }
}