package com.purposebakery.androidskeleton.features.pod.ui

import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.purposebakery.androidskeleton.R
import com.purposebakery.androidskeleton.core.BaseUiStateActivity
import com.purposebakery.androidskeleton.framework.configuration.CheckNotReleaseUseCase
import com.purposebakery.design.components.buttons.CDButton
import com.purposebakery.design.theme.AndroidSkeletonTheme
import com.purposebakery.design.theme.SizeX1
import com.purposebakery.design.theme.SizeX2
import com.purposebakery.design.theme.Typography
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PodActivity : BaseUiStateActivity<PodUiState>() {
    override val viewModel: PodViewModel by viewModels()

    @Composable
    override fun MainContent(uiState: PodUiState) {
        PodContent(
            uiState = uiState,
            onPodButtonPressed = viewModel::onPodButtonPressed
        )
    }
}

@Composable
fun PodContent(
    uiState: PodUiState,
    onPodButtonPressed: () -> Unit
) {
    val buttonText = uiState.loadButtonText
    val podUrl = uiState.podUrl

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        PodLoadButton(buttonText, onPodButtonPressed)
        PodImage(podUrl)
        PodInformation(uiState.podTitle, uiState.podExplanation, uiState.podDate)
    }
}

@Composable
fun PodNasaLogo() {
    val image: Painter = painterResource(R.drawable.nasa_logo)
    Image(
        alignment = Alignment.Center,
        painter = image,
        modifier = Modifier.fillMaxWidth(),
        contentDescription = LocalContext.current.getString(R.string.pod_nasa_image_content_description)
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
            .padding(SizeX2)
    )
}

@Composable
fun PodImage(
    podUrl: String?
) {
    if (podUrl == null) {
        PodNasaLogo()
    } else {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SizeX2),
            model = ImageRequest.Builder(LocalContext.current)
                .data(podUrl)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.pod_image_content_description),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun PodInformation(
    podTitle: String?,
    podExplanation: String?,
    podDate: String?,
) {
    podTitle?.run {
        Text(
            text = podTitle,
            modifier = Modifier
                .padding(start = SizeX2, end = SizeX2, top = SizeX1),
            style = Typography.h5
        )
    }

    podDate?.run {
        Text(
            text = podDate,
            modifier = Modifier
                .padding(start = SizeX2, end = SizeX2, top = SizeX1),
        )
    }

    podExplanation?.run {
        Text(
            text = podExplanation,
            modifier = Modifier
                .padding(start = SizeX2, end = SizeX2, top = SizeX1),
        )
    }
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
                podTitle = "Title"
                podExplanation = "Explanation"
                podDate = "10. Dec 2020"
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