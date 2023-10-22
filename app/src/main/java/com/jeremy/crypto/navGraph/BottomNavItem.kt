package com.jeremy.crypto.navGraph

import androidx.annotation.DrawableRes
import com.jeremy.crypto.designsystem.BottomBar.FavoriteDrawable
import com.jeremy.crypto.designsystem.BottomBar.FavoriteTabString
import com.jeremy.crypto.designsystem.BottomBar.HomeDrawable
import com.jeremy.crypto.designsystem.BottomBar.HomeTabString


sealed class BottomNavItem(
    val title: Int,
    @DrawableRes val icon: Int,
    val screenRoute: String
) {
    object Home : BottomNavItem(HomeTabString, HomeDrawable, "home")
    object Favorite : BottomNavItem(FavoriteTabString, FavoriteDrawable, "favorite")
}

