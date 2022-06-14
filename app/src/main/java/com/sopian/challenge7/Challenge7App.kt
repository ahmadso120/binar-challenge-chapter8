package com.sopian.challenge7

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sopian.challenge7.ui.UnsplashTabs
import com.sopian.challenge7.ui.theme.Challenge7Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Challenge7App(
    isUserHasLoggedIn: Boolean,
    finishActivity: () -> Unit
) {
    val tabs = remember { UnsplashTabs.values() }
    val navController = rememberNavController()
    Challenge7Theme {
        Scaffold(
            bottomBar = { BottomBar(navController, tabs) }
        ) { innerPaddingModifier ->
            NavGraph(
                navController = navController,
                finishActivity = finishActivity,
                modifier = Modifier.padding(innerPaddingModifier),
                isUserHasLoggedIn = isUserHasLoggedIn
            )
        }
    }
}

@Composable
fun BottomBar(navController: NavController, tabs: Array<UnsplashTabs>) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
        ?: UnsplashTabs.HOME.route

    val routes = remember {
        UnsplashTabs.values().map { it.route }
    }

    if (currentRoute in routes) {
        NavigationBar {
            tabs.forEach { tab ->
                NavigationBarItem(
                    icon = { Icon(tab.icon, contentDescription = null) },
                    label = { Text(stringResource(tab.title).uppercase()) },
                    selected = currentRoute == tab.route,
                    onClick = {
                        if (tab.route != currentRoute) {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    }

}