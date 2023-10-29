package com.jeremy.crypto.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jeremy.crypto.main.bottom.BottomNavigation
import com.jeremy.crypto.main.navigation.detailNavigation
import com.jeremy.crypto.main.navigation.mainNavigation
import com.jeremy.crypto.navigation.AppComposeNavigator
import com.jeremy.crypto.navigation.route.MainRoute

@Composable
fun MainScreen(
    composeNavigator: AppComposeNavigator,
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val state = mainViewModel.viewState.collectAsStateWithLifecycle().value
    MainScaffold(
        state,
        composeNavigator,
        navController
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScaffold(
    mainViewState: MainViewState,
    composeNavigator: AppComposeNavigator,
    navController: NavHostController,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigation(navController = navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            when (mainViewState.fetchSuccess) {
                true -> {
                    NavHost(
                        navController = navController,
                        startDestination = MainRoute.Main.route
                    ) {
                        mainNavigation(composeNavigator)
                        detailNavigation(composeNavigator)
                    }
                }
                false -> {
                    when (mainViewState.fetchError) {
                        true -> {
                            // Global Error Screen
                        }
                        false -> CircularProgressIndicator()
                    }
                }
            }
        }
    }
}

