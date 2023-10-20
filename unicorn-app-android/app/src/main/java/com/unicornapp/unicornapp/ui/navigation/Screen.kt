package com.unicornapp.unicornapp.ui.navigation

sealed class Screen(val route: String) {
    object LandingScreen: Screen(route = "landing_screen")
    object LoginScreen: Screen(route = "login_screen")
    object MainScreen: Screen(route = "main_screen")
    object HomeScreen: Screen(route = "home_screen")
    object ContactScreen: Screen(route = "contact_screen")
    object NotificationScreen: Screen(route = "notification_screen")
    object HomeDetailScreen: Screen(route = "home_detail_screen")
}