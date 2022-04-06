package com.purposebakery.androidskeleton.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.purposebakery.design.theme.AndroidSkeletonTheme
import kotlinx.coroutines.launch

abstract class BaseUiStateActivity<T> : ComponentActivity() {

    abstract val viewModel: BaseUiStateViewModel<T>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repeatOnStarted {
            viewModel.uiState.collect { uiState ->
                setSurface {
                    MainContent(uiState)
                }
            }
        }
    }

    @Composable
    abstract fun MainContent(uiState: T)

    private fun setSurface(content: @Composable () -> Unit) {
        setContent {
            AndroidSkeletonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    return@Surface content.invoke()
                }
            }
        }
    }

    private fun repeatOnStarted(callback: suspend () -> Unit) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                callback.invoke()
            }
        }
    }
}