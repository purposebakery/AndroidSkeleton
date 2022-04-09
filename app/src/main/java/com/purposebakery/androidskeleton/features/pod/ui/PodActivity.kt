package com.purposebakery.androidskeleton.features.pod.ui

import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.purposebakery.androidskeleton.R
import com.purposebakery.androidskeleton.core.BaseUiStateActivity
import com.purposebakery.androidskeleton.framework.configuration.CheckNotReleaseUseCase
import com.purposebakery.design.components.buttons.CDButton
import com.purposebakery.design.components.images.CDImage
import com.purposebakery.design.theme.AndroidSkeletonTheme
import com.purposebakery.design.theme.SizeX1
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PodActivity : BaseUiStateActivity<PodUiState>() {
    override val viewModel: PodViewModel by viewModels()

    @Composable
    override fun MainContent(uiState: PodUiState) {
        DefaultPreview()
        /*
        PodContent(
            uiState = uiState,
            onPodButtonPressed = viewModel::onPodButtonPressed
        )*/
    }
}

@Composable
fun PodContent(
    uiState: PodUiState,
    onPodButtonPressed: () -> Unit
) {
    val buttonText = uiState.loadButtonText
    val podUrl = uiState.podUrl

    Column {
        PodNasaLogo()
        PodLoadButton(buttonText, onPodButtonPressed)
        PodImage(podUrl)
    }
}

@Composable
fun PodNasaLogo() {
    CDImage(
        imageResourceId = R.drawable.nasa_logo,
        contentDescription = R.string.pod_nasa_image_content_description
    )
}

@Composable
fun PodLoadButton(
    buttonText: String,
    buttonPressed: () -> Unit
) {
    CDButton(
        text = buttonText,
        onClick = buttonPressed,
        modifier = Modifier
            .fillMaxWidth()
            .padding(SizeX1)
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
        contentDescription = stringResource(R.string.pod_image_content_description),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CheckNotReleaseUseCase()
    AndroidSkeletonTheme {
        PodContent(
            PodUiState().apply {
                loadButtonText = "Load Button Text Private"
                podUrl = ""
            },
            previewCallback()
        )
    }
}

@Composable
private fun previewCallback(): () -> Unit {
    val context = LocalContext.current
    return {
        Toast.makeText(context, "No preview for this action.", Toast.LENGTH_SHORT).show()
    }
}