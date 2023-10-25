package com.jeremy.crypto.navigation

sealed class NavigationCommand {
    object NavigateUp : NavigationCommand()
}