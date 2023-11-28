package com.jeremy.crypto.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.jeremy.crypto.core.designsystem.R

@Composable
fun FavoriteButton(
    checked: Boolean,
    onCheckedChange: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    if (enabled) {
        Image(
            painter =
            if (checked) painterResource(R.drawable.baseline_favorite_selected_24)
            else painterResource(
                R.drawable.outline_favorite_border_24
            ),
            contentDescription = "",
            modifier = modifier.clickable {
                onCheckedChange.invoke()
            },
        )
    }
}