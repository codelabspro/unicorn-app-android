package com.unicornapp.unicornapp.ui.screens

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.unicornapp.unicornapp.R
import com.unicornapp.unicornapp.ui.navigation.Screen
import com.unicornapp.unicornapp.ui.theme.PrimaryColor
import com.unicornapp.unicornapp.ui.theme.TertiaryColor
import com.unicornapp.unicornapp.ui.theme.TransparentColor
import com.unicornapp.unicornapp.ui.theme.createGradientEffect

@Composable
fun LandingScreen(
    navController: NavController
) {
    LaunchedEffect(key1 = "LandingScreenAppeared") {
        Log.d("UnicornApp", "navController: $navController, route: ${Screen.LoginScreen.route}")
    }
    val gradientColors = listOf(
        PrimaryColor,
        PrimaryColor
    )
    var showExpandedText by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = createGradientEffect(
                    colors = gradientColors,
                    isVertical = true
                )
            ),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 0.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.unicorn_white),
                contentDescription = stringResource(id = R.string.unicorn_content_description),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(150.dp)
            )
            ClickableText(
                text = AnnotatedString("UnicornApp"),
                style = MaterialTheme.typography.h3.copy(color = Color.White),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                onClick = {
                    showExpandedText = !showExpandedText
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            AnimatedVisibility(visible = showExpandedText) {
                Text(
                    text = "The Unicorn App Platform",
                    color = Color.White,
                    style = MaterialTheme.typography.body1.copy(color = Color.White),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    /* TODO-FIXME
                    navigator.navigate(HomeScreenDestination(
                        name = "TestUser"
                    ))
                    */
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(TransparentColor)
            ) {
                Text(text = "GetStarted")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                          navController.navigate(
                              Screen.LoginScreen.route
                          )
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(TransparentColor)
            ) {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    navController.navigate(
                        Screen.RegistrationScreen.route
                    )
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(TransparentColor)
            ) {
                Text(text = "Sign Up")
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}



@Composable
@Preview
fun LandingScreenPreview() {
    // TODO-FIXME LandingScreen(navigator = MockDestinationsNavigator())
}