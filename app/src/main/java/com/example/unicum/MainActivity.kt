package com.example.unicum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.unicum.presentation.navgraph.NavGraph
import com.example.unicum.ui.theme.UnicumTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnicumTheme {
                NavGraph(startDestination = viewModel.startDestination.value)
            }
        }
    }
}

