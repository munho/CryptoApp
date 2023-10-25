package com.jeremy.crypto.main.bottom

import androidx.annotation.DrawableRes
import com.jeremy.crypto.designsystem.BottomBar.FavoriteDrawable
import com.jeremy.crypto.designsystem.BottomBar.FavoriteTabString
import com.jeremy.crypto.designsystem.BottomBar.HomeDrawable
import com.jeremy.crypto.designsystem.BottomBar.HomeTabString
import com.jeremy.crypto.navigation.route.MainRoute
import com.jeremy.crypto.navigation.route.ScreenRoute


sealed class BottomNavItem(
    val title: Int,
    @DrawableRes val icon: Int,
    val screenRoute: String
) {
    object Home : BottomNavItem(HomeTabString, HomeDrawable, ScreenRoute.Home.route)
    object Favorite : BottomNavItem(FavoriteTabString, FavoriteDrawable, ScreenRoute.Favorite.route)
}

