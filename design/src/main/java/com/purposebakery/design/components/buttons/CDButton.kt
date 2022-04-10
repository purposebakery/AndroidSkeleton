package com.purposebakery.design.components.buttons

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CDButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        content = {
            Text(
                text = text,
            )
        },
        onClick = onClick,
        modifier = modifier
    )
}