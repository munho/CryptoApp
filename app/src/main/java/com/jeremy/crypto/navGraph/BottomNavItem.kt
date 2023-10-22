package com.jeremy.crypto.navGraph

import androidx.annotation.DrawableRes
import com.jeremy.crypto.designsystem.BottomBar.FavoriteDrawable
import com.jeremy.crypto.designsystem.BottomBar.FavoriteTabString
import com.jeremy.crypto.designsystem.BottomBar.HomeDrawable
import com.jeremy.crypto.designsystem.BottomBar.HomeTabString
import com.jeremy.crypto.favorite.favoriteRoute
import com.jeremy.crypto.home.homeRoute


sealed class BottomNavItem(
    val title: Int,
    @DrawableRes val icon: Int,
    val screenRoute: String
) {
    object Home : BottomNavItem(HomeTabString, HomeDrawable, homeRoute)
    object Favorite : BottomNavItem(FavoriteTabString, FavoriteDrawable, favoriteRoute)
}

