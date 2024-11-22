@file:OptIn(ExperimentalHorologistApi::class)

package org.michaelbel.template

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.layout.AppScaffold
import com.google.android.horologist.compose.layout.ScreenScaffold
import com.google.android.horologist.compose.layout.rememberColumnState

class WearMainActivity: ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberSwipeDismissableNavController()
            WearApp(
                navController = navController
            )
        }
    }
}

@Composable
fun WearApp(
    navController: NavHostController
) {
    AppScaffold {
        SwipeDismissableNavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(
                route = Screen.Home.route
            ) {
                val scrollState = rememberColumnState()
                ScreenScaffold(
                    modifier = Modifier.fillMaxSize(),
                    scrollState = scrollState
                ) {

                    Text(
                        text = "Home",
                        modifier = Modifier.fillMaxSize().align(Alignment.Center),
                        style = MaterialTheme.typography.title1,
                        textAlign = TextAlign.Center
                    )
                }
            }
            composable(
                route = Screen.Chat.route
            ) {
                val scrollState = rememberColumnState()
                ScreenScaffold(
                    scrollState = scrollState
                ) {
                    Text(
                        text = "Chat",
                        style = MaterialTheme.typography.title1,
                        textAlign = TextAlign.Center
                    )
                }
            }
            composable(
                route = Screen.Settings.route
            ) {
                val scrollState = rememberColumnState()
                ScreenScaffold(
                    scrollState = scrollState
                ) {
                    Text(
                        text = "Settings",
                        style = MaterialTheme.typography.title1,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

sealed class Screen(
    val route: String
) {
    data object Home: Screen("home")
    data object Chat: Screen("chat")
    data object Settings: Screen("settings")
}