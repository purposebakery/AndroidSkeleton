package com.purposebakery.androidskeleton.features.pod.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.purposebakery.androidskeleton.common.BaseActivity
import com.purposebakery.design.theme.AndroidSkeletonTheme

class PodActivity : BaseActivity() {
    @Composable
    override fun Content() {
        Greeting("Android")
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidSkeletonTheme {
        Greeting("Android")
    }
}