package com.example.unicum.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unicum.domain.model.Coffee
import com.example.unicum.presentation.screens.details.DetailsScreen
import com.example.unicum.presentation.screens.details.DetailsViewModel
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
                navController = navController,
                state = viewModel.state.value,
                navigateToDetails = { coffee ->
                    navigateToDetails(
                        navController = navController,
                        coffee = coffee
                    )
                },
                navigateUp = { navController.navigateUp() }

            )
        }
        composable(route = Route.DetailsScreen.route) {
            val viewModel: DetailsViewModel = hiltViewModel()
            val homeViewModel: HomeViewModel = hiltViewModel()
            navController.previousBackStackEntry?.savedStateHandle?.get<Coffee?>("coffee")
                ?.let { coffee ->
                    DetailsScreen(
                        navController = navController,
                        coffee = coffee,
                        listCoffees = homeViewModel.state.value.coffees,
                        viewModel::onEvent,
                        viewModel.sideEffect,
                        navigateUp = { navController.navigateUp() }
                    )
                }

        }
    }
}

private fun navigateToDetails(navController: NavController, coffee: Coffee) {
    navController.currentBackStackEntry?.savedStateHandle?.set("coffee", coffee)
    navController.navigate(route = Route.DetailsScreen.route)
}
