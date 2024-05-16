package com.example.unicum

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.unicum.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

//    private val _startDestination = mutableStateOf(Route.HomeScreen.route)
//        val startDestination: State<String> = _startDestination
//
//    init {
//        _startDestination.value = Route.HomeScreen.route
//    }
}