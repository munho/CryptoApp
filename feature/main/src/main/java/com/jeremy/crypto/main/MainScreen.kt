package com.jeremy.crypto.main

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jeremy.crypto.main.bottom.BottomNavItem
import com.jeremy.crypto.main.bottom.BottomNavigation
import com.jeremy.crypto.main.navigation.detailNavigation
import com.jeremy.crypto.main.navigation.mainNavigation
import com.jeremy.crypto.navigation.AppComposeNavigator
import com.jeremy.crypto.navigation.route.MainRoute

@Composable
fun MainScreen(
    composeNavigator: AppComposeNavigator,
    navController: NavHostController
) {
    MainScaffold(composeNavigator, navController)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScaffold(
    composeNavigator: AppComposeNavigator,
    navController: NavHostController
) {
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = MainRoute.Main.route
            ) {
                mainNavigation(composeNavigator)
                detailNavigation(composeNavigator)
            }
        }
    }
}

