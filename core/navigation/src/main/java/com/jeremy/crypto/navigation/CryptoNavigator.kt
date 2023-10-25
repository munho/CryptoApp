package com.jeremy.crypto.navigation

import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CryptoNavigator @Inject constructor() : AppComposeNavigator() {
    override fun navigate(route: String, optionsBuilder: (NavOptionsBuilder.() -> Unit)?) {
        val options = optionsBuilder?.let { navOptions(it) }
        navigationCommands.tryEmit(ComposeNavigationCommand.NavigateToRoute(route, options))
    }

    override fun <T> observeResult(key: String, route: String?): Flow<T> {
        return navControllerFlow
            .filterNotNull()
            .flatMapLatest { navController ->
                val backStackEntry = route?.let { navController.getBackStackEntry(it) }
                    ?: navController.currentBackStackEntry

                backStackEntry?.savedStateHandle?.let { savedStateHandle ->
                    savedStateHandle
                        .getStateFlow<T?>(key, null)
                        .filterNotNull()
                        .onEach {
                            savedStateHandle[key] = null
                        }
                } ?: emptyFlow()
            }
    }

    override fun <T> navigateBackWithResult(key: String, result: T, route: String?) {
        navigationCommands.tryEmit(
            ComposeNavigationCommand.NavigateUpWithResult(
                key = key,
                result = result,
                route = route,
            ),
        )
    }

    override fun popUpTo(route: String, inclusive: Boolean) {
        navigationCommands.tryEmit(ComposeNavigationCommand.PopUpToRoute(route, inclusive))
    }

    override fun navigateAndClearBackStack(route: String) {
        navigationCommands.tryEmit(
            ComposeNavigationCommand.NavigateToRoute(
                route,
                navOptions {
                    popUpTo(0)
                },
            ),
        )
    }
}
