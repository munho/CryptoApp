package com.jeremy.crypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.jeremy.crypto.main.MainScreen
import com.jeremy.crypto.navigation.AppComposeNavigator
import com.jeremy.crypto.ui.theme.CryptoCurrencyTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var appComposeNavigator: AppComposeNavigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            LaunchedEffect(Unit) {
                appComposeNavigator.handleNavigationCommands(navHostController)
            }
            CryptoCurrencyTheme {
                MainScreen(
                    composeNavigator = appComposeNavigator,
                    navController = navHostController,
                )
            }
        }
    }
}
