package com.purposebakery.androidskeleton.features.pod.ui

import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
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
        val buttonText by viewModel.loadButtonTextLiveData.observeAsState("")
        PodContent(
            buttonText = buttonText,
            buttonPressed = viewModel::onPodButtonPressed
        )
    }
}

@Composable
fun PodContent(
    buttonText: String,
    buttonPressed: () -> Unit
) {
    Column {
        PodNasaLogo()
        PodLoadButton(buttonText, buttonPressed)
    }
}

@Composable
fun PodNasaLogo() {
    val image: Painter = painterResource(id = R.drawable.nasa_logo)
    Image(painter = image, contentDescription = LocalContext.current.getString(R.string.pod_nasa_image_content_description))
}

@Composable
fun PodLoadButton(
    buttonText: String,
    buttonPressed: () -> Unit
) {
    Button(
        content = {
            Text(
                text = buttonText,
            )
        },
        onClick = buttonPressed,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidSkeletonTheme {
        PodContent(
            buttonText = "Button Text Preview",
            buttonPressed = {}
        )
    }
}