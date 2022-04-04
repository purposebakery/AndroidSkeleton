package com.purposebakery.androidskeleton.features.pod.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.purposebakery.androidskeleton.common.BaseActivity
import com.purposebakery.design.theme.AndroidSkeletonTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.purposebakery.androidskeleton.R

class PodActivity : BaseActivity() {
    @Composable
    override fun Content() {
        PodContent()
    }
}


@Composable
fun PodContent() {
    Column {
        PodNasaLogo()
        Text(text = "Click me for picture of the day")
    }
}

@Composable
fun PodNasaLogo() {
    val image: Painter = painterResource(id = R.drawable.nasa_logo)
    Image(painter = image,contentDescription = "Nasa Logo")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidSkeletonTheme {
        PodContent()
    }
}