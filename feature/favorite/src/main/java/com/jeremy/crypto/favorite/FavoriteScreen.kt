package com.jeremy.crypto.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jeremy.crypto.navigation.AppComposeNavigator

@Composable
fun FavoriteScreen(appNavigator: AppComposeNavigator) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "This is Favorite")

    }
}