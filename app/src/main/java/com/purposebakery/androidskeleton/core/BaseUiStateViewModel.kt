package com.purposebakery.androidskeleton.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.StateFlow

interface UiState

abstract class BaseUiStateViewModel<T>(app : Application) : AndroidViewModel(app) {
    abstract val uiState : StateFlow<T>
}