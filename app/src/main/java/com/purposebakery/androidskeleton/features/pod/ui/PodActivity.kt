package com.purposebakery.androidskeleton.features.pod.ui

import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
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
        PodContent(
            buttonText = viewModel.loadButtonText.observeAsState("").value,
            buttonPressed = viewModel::onPodButtonPressed,
            podUrl = viewModel.podUrl.observeAsState(null).value
        )
    }
}

@Composable
fun PodContent(
    buttonText: String,
    buttonPressed: () -> Unit,
    podUrl: String?
) {
    Column {
        PodNasaLogo()
        PodLoadButton(buttonText, buttonPressed)
        PodImage(podUrl)
    }
}

@Composable
fun PodNasaLogo() {
    val image: Painter = painterResource(id = R.drawable.nasa_logo)
    Image(
        painter = image,
        contentDescription = LocalContext.current.getString(R.string.pod_nasa_image_content_description)
    )
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

@Composable
fun PodImage(
    podUrl: String?
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(podUrl)
            .crossfade(true)
            .build(),
        //placeholder = painterResource(R.drawable.placeholder),
        contentDescription = stringResource(R.string.pod_image_content_description),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidSkeletonTheme {
        PodContent(
            buttonText = "Button Text Preview",
            buttonPressed = {},
            podUrl = "https://apod.nasa.gov/apod/image/2204/VortexAurora_Suarez_1080.jpg"
        )
    }
}