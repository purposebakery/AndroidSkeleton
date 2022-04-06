package com.purposebakery.androidskeleton.features.pod.state

import com.purposebakery.androidskeleton.R
import com.purposebakery.androidskeleton.features.pod.ui.PodViewModel
import com.purposebakery.androidskeleton.test.core.BaseViewModelTest
import com.purposebakery.androidskeleton.test.extensions.assertEqualsStringResource
import org.junit.Before
import org.junit.Test

class PodViewModelTest : BaseViewModelTest() {
    private lateinit var viewModel: PodViewModel

    @Before
    fun setup() {
        viewModel = PodViewModel(app)
    }

    @Test
    fun `initializes with correct values`() {
        // Then
        assertEqualsStringResource(viewModel.loadButtonText.value, R.string.pod_load_button)
    }

    @Test
    fun `onPodButtonPressed - sets button text to reloaded string`() {
        // When
        viewModel.onPodButtonPressed()

        // Then
        assertEqualsStringResource(viewModel.loadButtonText.value, R.string.pod_reload_button)
    }
}