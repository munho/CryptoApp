package com.jeremy.crypto.navigation.route

sealed class ScreenRoute(val route: String) {
    object Home : ScreenRoute("ScreenHome")
    object Favorite : ScreenRoute("ScreenFavorite")
    object CryptoDetail : ScreenRoute("ScreenDetail")
}