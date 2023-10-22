package com.jeremy.crypto.favorite

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

const val favoriteRoute = "favorite_route"

fun NavGraphBuilder.favoriteNavGraph(navHostController: NavHostController, modifier: Modifier) {
    composable(
        route = favoriteRoute
    ) {
        FavoriteScreen()
    }
}