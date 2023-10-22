package com.jeremy.crypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.jeremy.crypto.navGraph.Graph
import com.jeremy.crypto.navGraph.RootNavGraph
import com.jeremy.crypto.ui.theme.CryptoCurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            CryptoCurrencyTheme {
                RootNavGraph(
                    navController = navController,
                    startDestination = Graph.MAIN
                )
            }
        }
    }
}
