package com.example.unicum.presentation.navgraph

sealed class Route(
    val route: String
) {

    data object HomeScreen : Route(route = "home_screen")
    data object DetailsScreen : Route(route = "details_screen")
    data object AppStartNavigation : Route(route = "app_start_navigation")
}