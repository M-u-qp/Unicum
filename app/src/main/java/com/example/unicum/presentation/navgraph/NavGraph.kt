package com.example.unicum.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.unicum.presentation.screens.home.HomeScreen
import com.example.unicum.presentation.screens.home.HomeViewModel

@Composable
fun NavGraph(
    startDestination: String
) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.HomeScreen.route
        ) {
            composable(route = Route.HomeScreen.route) {
                val viewModel: HomeViewModel = hiltViewModel()
                HomeScreen(
                    state = viewModel.state.value,
                    navigate = {
                        navController.navigate(Route.DetailsScreen.route)
                    }
                )
            }
        }
    }
}