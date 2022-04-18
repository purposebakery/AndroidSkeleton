package com.purposebakery.androidskeleton.instrumentation.pod

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.purposebakery.androidskeleton.features.pod.ui.DefaultPreview
import com.purposebakery.design.theme.AndroidSkeletonTheme
import org.junit.Rule
import org.junit.Test

class PodUiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myTest() {
        composeTestRule.setContent {
            AndroidSkeletonTheme {
                DefaultPreview()
            }
        }

        composeTestRule.onNodeWithText("Load picture of the day!").performClick()

        composeTestRule.onNodeWithText("Explanation").assertIsDisplayed()
    }

}