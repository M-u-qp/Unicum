package com.example.unicum.presentation.screens.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.unicum.R

@Composable
fun RuneroBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = colorResource(id = R.color.border_window)),
        contentAlignment = Alignment.CenterStart,
    ) {
        Row(modifier = Modifier.padding(start = 26.dp, top = 15.dp, bottom = 15.dp)) {
            Icon(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(24.dp),
                painter = painterResource(id = R.drawable.ic_runero_black_24dp),
                contentDescription = null,
                tint = colorResource(id = R.color.runero)
            )
            Text(
                text = "RUNERO Touch",
                color = colorResource(id = R.color.runero)
            )
        }
    }
}