package com.unicornapp.unicornapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.DestinationsNavHost
// TODO-FIXME-DEPRECATE import com.unicornapp.unicornapp.ui.navigation.SetupRootNavGraph
import com.unicornapp.unicornapp.ui.screens.NavGraphs
import com.unicornapp.unicornapp.ui.theme.UnicornAppTheme

class MainActivity : ComponentActivity() {
    lateinit var navHostController: NavHostController
    private val viewModel: UnicornViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        setContent {
            UnicornAppTheme {
                navHostController = rememberNavController()
                // A surface container using the 'background' color from the theme
                // MyApp(navController = navController)
                // SetupRootNavGraph(navController = navHostController)
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
