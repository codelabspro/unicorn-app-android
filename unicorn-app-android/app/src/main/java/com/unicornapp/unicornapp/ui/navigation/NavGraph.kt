package com.unicornapp.unicornapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.unicornapp.unicornapp.ui.screens.ContactScreen
import com.unicornapp.unicornapp.ui.screens.HomeDetailScreen
import com.unicornapp.unicornapp.ui.screens.HomeScreen
import com.unicornapp.unicornapp.ui.screens.LandingScreen
import com.unicornapp.unicornapp.ui.screens.LoginScreen
import com.unicornapp.unicornapp.ui.screens.MainScreen
import com.unicornapp.unicornapp.ui.screens.NotificationScreen
import com.unicornapp.unicornapp.ui.screens.RegistrationScreen

@Composable
fun SetupDrawerNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenDrawer.HomeScreen.route
        // TODO-FIXME-CLEANUP startDestination = Screen.MainScreen.route
    ) {

        composable(
            route = ScreenDrawer.HomeScreen.route
        ) {
            HomeScreen(
                navController = navController
            )
        }

        composable(
            route = ScreenDrawer.ContactScreen.route
        ) {
            ContactScreen(
                navController = navController
            )
        }

        composable(
            route = ScreenDrawer.NotificationScreen.route
        ) {
            NotificationScreen(
                navController = navController
            )
        }

    }
}

@Composable
fun SetupRootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LandingScreen.route
        // TODO-FIXME-CLEANUP startDestination = Screen.MainScreen.route
    ) {

        composable(
            route = Screen.LandingScreen.route
        ) {
            LandingScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.LoginScreen.route
        ) {
            LoginScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.RegistrationScreen.route
        ) {
            RegistrationScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.MainScreen.route
        ) {
            MainScreen(
                navController = navController
            )
        }
    }
}