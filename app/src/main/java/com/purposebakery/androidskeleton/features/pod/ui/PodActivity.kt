package com.purposebakery.androidskeleton.features.pod.ui

import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.purposebakery.androidskeleton.R
import com.purposebakery.androidskeleton.core.BaseActivity
import com.purposebakery.androidskeleton.features.pod.state.PodViewModel
import com.purposebakery.design.theme.AndroidSkeletonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PodActivity : BaseActivity() {
    private val viewModel: PodViewModel by viewModels()

    @Composable
    override fun Content() {
        PodContent(viewModel)
    }
}


@Composable
fun PodContent(viewModel: PodViewModel? = null) {
    Column {
        PodNasaLogo()
        Button(content = {
            Text(
                text = "Show me the picture of the day!",
            )
        }, onClick = {
            viewModel?.onPodButtonPressed()
        }, modifier = Modifier.fillMaxWidth().padding(16.dp))
    }
}

@Composable
fun PodNasaLogo() {
    val image: Painter = painterResource(id = R.drawable.nasa_logo)
    Image(painter = image, contentDescription = "Nasa Logo")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidSkeletonTheme {
        PodContent()
    }
}