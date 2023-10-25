package com.jeremy.crypto.navigation

import androidx.navigation.NavOptions

sealed class ComposeNavigationCommand : NavigationCommand() {
    data class NavigateToRoute(val route: String, val options: NavOptions? = null) :
        ComposeNavigationCommand()

    data class NavigateUpWithResult<T>(
        val key: String,
        val result: T,
        val route: String? = null,
    ) : ComposeNavigationCommand()

    data class PopUpToRoute(val route: String, val inclusive: Boolean) : ComposeNavigationCommand()
}
