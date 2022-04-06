package com.purposebakery.design.components.buttons

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.purposebakery.design.components.typography.CDText

@Composable
fun CDButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        content = {
            CDText(
                text = text,
            )
        },
        onClick = onClick,
        modifier = modifier
    )
}