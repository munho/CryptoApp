package com.jeremy.crypto.favorite

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jeremy.crypto.navigation.route.MainRoute
import com.jeremy.crypto.navigation.route.ScreenRoute
import com.jeremy.crypto.navigation.AppComposeNavigator
fun NavGraphBuilder.favoriteNavGraph(appNavigator: AppComposeNavigator) {
    navigation(
        startDestination = ScreenRoute.Favorite.route,
        route = MainRoute.Favorite.route,
    ) {
        composable(
            route = ScreenRoute.Favorite.route
        ) {
            FavoriteScreen(appNavigator)
        }
    }
}