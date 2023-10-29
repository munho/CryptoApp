package com.jeremy.crypto.main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jeremy.crypto.favorite.favoriteNavGraph
import com.jeremy.crypto.home.homeNavGraph
import com.jeremy.crypto.navigation.AppComposeNavigator
import com.jeremy.crypto.navigation.route.MainRoute
import com.jeremy.crypto.navigation.route.ScreenRoute

fun NavGraphBuilder.mainNavigation(
    composeNavigator: AppComposeNavigator,
) {
    navigation(
        startDestination = MainRoute.Home.route,
        route = MainRoute.Main.route,
    ) {
        homeNavGraph(composeNavigator)
        favoriteNavGraph(composeNavigator)
    }
}

fun NavGraphBuilder.detailNavigation(
    composeNavigator: AppComposeNavigator
) {
    navigation(
        startDestination = ScreenRoute.CryptoDetail.route,
        route = MainRoute.Detail.route
    ) {
        composable(ScreenRoute.CryptoDetail.route) {
            //CryptoDetailScreen(composeNavigator)
        }
    }
}