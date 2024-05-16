package com.example.unicum.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unicum.presentation.screens.details.DetailsScreen
import com.example.unicum.presentation.screens.home.HomeScreen
import com.example.unicum.presentation.screens.home.HomeViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.HomeScreen.route
    ) {
        composable(route = Route.HomeScreen.route) {
            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                state = viewModel.state.value,
                navigateToDetails = {
                    navController.navigate(Route.DetailsScreen.route)
                }
            )
        }
        composable(route = Route.DetailsScreen.route) {
            DetailsScreen()
        }
    }
}