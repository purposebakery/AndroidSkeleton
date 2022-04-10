package com.purposebakery.design.components.images

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

@Composable
fun CDImage(
    @DrawableRes imageResourceId: Int,
    @StringRes contentDescription: Int
) {
    CDImage(
        imageResourceId = imageResourceId,
        contentDescription = LocalContext.current.getString(contentDescription)
    )
}

@Composable
fun CDImage(
    @DrawableRes imageResourceId: Int,
    contentDescription: String
) {
    val image: Painter = painterResource(imageResourceId)
    Image(
        alignment = Alignment.Center,
        painter = image,
        contentDescription = contentDescription
    )
}