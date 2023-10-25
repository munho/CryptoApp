package com.jeremy.crypto.main.bottom

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorite
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = items.any { it.screenRoute == currentDestination?.route }

    if (bottomBarDestination) {
        BottomNavigation(
            backgroundColor = Color.White,
            contentColor = Color(0xFF3F414E),
            modifier = Modifier.height(60.dp)
        ) {
            items.forEach { item ->
                val selected = currentDestination?.hierarchy?.any { it.route == item.screenRoute } == true
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = stringResource(id = item.title),
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp)
                        )
                    },
                    label = { Text(stringResource(id = item.title), fontSize = 9.sp) },
                    selectedContentColor = MaterialTheme.colors.primary,
                    unselectedContentColor = Color.Gray,
                    selected = selected,
                    onClick = {
                        navController.navigate(item.screenRoute) {
                            navController.graph.startDestinationRoute?.let {
                                popUpTo(it) { saveState = true }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}