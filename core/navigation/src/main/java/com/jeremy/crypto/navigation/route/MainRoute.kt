package com.jeremy.crypto.navigation.route

sealed class MainRoute(val route: String) {
    object Main : MainRoute("main")
    object Home : MainRoute("home")
    object Favorite : MainRoute("favorite")
    object Detail : MainRoute("detail")
}