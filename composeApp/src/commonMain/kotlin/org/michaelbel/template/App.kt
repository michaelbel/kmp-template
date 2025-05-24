package org.michaelbel.template

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Composable
fun App() {
    val navHostController = rememberNavController()
    var selectedRoute by remember { mutableStateOf<Navigation>(Navigation.Home) }

    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        NavigationSuiteScaffold(
            navigationSuiteItems = {
                item(
                    selected = selectedRoute == Navigation.Home,
                    onClick = { selectedRoute = Navigation.Home },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = "Home"
                        )
                    }
                )
                item(
                    selected = selectedRoute == Navigation.Chat,
                    onClick = { selectedRoute = Navigation.Chat },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = "Chat"
                        )
                    }
                )
                item(
                    selected = selectedRoute == Navigation.Settings,
                    onClick = { selectedRoute = Navigation.Settings },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = "Settings"
                        )
                    }
                )
            }
        ) {
            NavHost(
                navController = navHostController,
                startDestination = selectedRoute
            ) {
                composable<Navigation.Home> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Home"
                        )
                    }
                }
                composable<Navigation.Chat> {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Chat"
                        )
                    }
                }
                composable<Navigation.Settings> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Settings"
                        )
                    }
                }
            }
        }
    }
}

sealed interface Navigation {

    @Serializable
    data object Home: Navigation

    @Serializable
    data object Chat: Navigation

    @Serializable
    data object Settings: Navigation
}