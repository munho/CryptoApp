package com.jeremy.crypto.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jeremy.crypto.navigation.AppComposeNavigator
import com.jeremy.crypto.navigation.route.MainRoute

@Composable
fun HomeScreen(
    appNavigator: AppComposeNavigator
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "This is Main")
    }
}