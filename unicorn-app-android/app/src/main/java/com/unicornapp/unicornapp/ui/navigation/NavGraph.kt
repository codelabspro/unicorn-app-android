package com.unicornapp.unicornapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.unicornapp.unicornapp.ui.screens.ContactScreen
import com.unicornapp.unicornapp.ui.screens.HomeDetailScreen
import com.unicornapp.unicornapp.ui.screens.HomeScreen
import com.unicornapp.unicornapp.ui.screens.NotificationScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.HomeDetailScreen.route
        ) {
            HomeDetailScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.NotificationScreen.route
        ) {
            NotificationScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.ContactScreen.route
        ) {
            ContactScreen(
                navController = navController
            )
        }
    }
}