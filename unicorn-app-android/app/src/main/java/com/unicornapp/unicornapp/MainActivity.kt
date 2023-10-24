package com.unicornapp.unicornapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.unicornapp.unicornapp.ui.navigation.CustomAppBar
import com.unicornapp.unicornapp.ui.navigation.DrawerBody
import com.unicornapp.unicornapp.ui.navigation.MenuItem
import com.unicornapp.unicornapp.ui.navigation.Screen
import com.unicornapp.unicornapp.ui.navigation.SetupRootNavGraph
import com.unicornapp.unicornapp.ui.screens.HomeScreen
import com.unicornapp.unicornapp.ui.screens.NavGraphs
import com.unicornapp.unicornapp.ui.theme.UnicornAppTheme
import kotlinx.coroutines.launch

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
                // TODO-FIXME-CLEANUP SetupRootNavGraph(navController = navHostController)
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
