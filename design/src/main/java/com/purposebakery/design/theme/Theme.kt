package com.purposebakery.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = NasaBlue,
    primaryVariant = NasaBlue,
    secondary = NasaRed,
    background = BackgroundDark
)

private val LightColorPalette = lightColors(
    primary = NasaBlue,
    primaryVariant = NasaBlue,
    secondary = NasaRed,
    background = BackgroundLight
)

@Composable
fun AndroidSkeletonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}