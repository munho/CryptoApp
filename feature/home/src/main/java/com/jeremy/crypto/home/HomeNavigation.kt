package com.jeremy.crypto.home

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

const val homeRoute = "home_route"

fun NavGraphBuilder.homeNavGraph(navHostController: NavHostController, modifier: Modifier) {
    composable(
        route = homeRoute
    ) {
        HomeScreen()
    }
}