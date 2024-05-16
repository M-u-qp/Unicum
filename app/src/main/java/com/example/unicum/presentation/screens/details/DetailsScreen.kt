package com.example.unicum.presentation.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.unicum.presentation.Dimens

@Composable
fun DetailsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding()
    ) {
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
        Text(text = "ЭКРАН НАСТРОЙКИ",
            fontSize = 30.sp)
    }
}