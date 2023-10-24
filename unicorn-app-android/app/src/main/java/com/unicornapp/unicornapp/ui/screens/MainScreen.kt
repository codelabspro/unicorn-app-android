package com.unicornapp.unicornapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.annotation.Destination
import com.unicornapp.unicornapp.ui.navigation.CustomAppBar
import com.unicornapp.unicornapp.ui.navigation.DrawerBody
import com.unicornapp.unicornapp.ui.navigation.MenuItem
import com.unicornapp.unicornapp.ui.navigation.SetupDrawerNavGraph
import kotlinx.coroutines.launch

@Destination
@Composable
fun MainScreen(
    navController: NavController,
    titles: List<String> = listOf("Unicorn")
) {
    var drawerNavHostController: NavHostController
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerBody(
                items = listOf(
                    MenuItem(
                        id = "home",
                        title = "Home",
                        route = "home_screen",
                        contentDescription = "Navigate to Home",
                        icon = Icons.Default.Home
                    ),
                    MenuItem(
                        id = "contact",
                        title = "Contact",
                        route = "contact_screen",
                        contentDescription = "Navigate to Contact",
                        icon = Icons.Default.Email
                    ),
                    MenuItem(
                        id = "notifications",
                        title = "Notifications",
                        route = "notification_screen",
                        contentDescription = "Navigate to Notifications",
                        icon = Icons.Default.Notifications
                    )
                ),
                onItemClick = {menuItem ->
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                    println("Clicked on ${menuItem.title}")
                    navController.navigate(route = menuItem.route)
                }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            drawerNavHostController = rememberNavController()
            SetupDrawerNavGraph(navController = drawerNavHostController as NavHostController)
            CustomAppBar(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        }
    }
}

@Composable
@Preview
fun MainScreenPreview() {
    // BottomNavigationMainScreen("Main", rememberNavController())
}