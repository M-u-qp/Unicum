package com.example.unicum.presentation.navgraph

import com.example.unicum.utils.Constants.APP_START_DESTINATION
import com.example.unicum.utils.Constants.DETAILS_SCREEN
import com.example.unicum.utils.Constants.HOME_SCREEN

sealed class Route(
    val route: String
) {
    data object HomeScreen : Route(route = HOME_SCREEN)
    data object DetailsScreen : Route(route = DETAILS_SCREEN)
    data object AppStartNavigation : Route(route = APP_START_DESTINATION)
}