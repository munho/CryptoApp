package com.jeremy.crypto.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jeremy.crypto.navigation.route.MainRoute
import com.jeremy.crypto.navigation.route.ScreenRoute
import com.jeremy.crypto.navigation.AppComposeNavigator


fun NavGraphBuilder.homeNavGraph(
    appNavigator: AppComposeNavigator
) {
    navigation(
        startDestination = ScreenRoute.Home.route,
        route = MainRoute.Home.route,
    ) {
        composable(
            route = ScreenRoute.Home.route
        ) {
            HomeScreen(appNavigator)
        }
    }
}