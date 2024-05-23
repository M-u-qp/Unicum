package com.example.unicum.presentation.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.unicum.R
import com.example.unicum.presentation.Dimens.ExtraSmallOffset2
import com.example.unicum.presentation.Dimens.ImageMediumSize2
import com.example.unicum.presentation.Dimens.MediumIconSize1
import com.example.unicum.presentation.Dimens.MediumMinusOffset1
import com.example.unicum.presentation.Dimens.MediumMinusOffset2
import com.example.unicum.presentation.Dimens.MediumOffset1
import com.example.unicum.ui.theme.Orange

@Composable
fun CoffeeCup(
    coffeeGlassState: Int,
    outsideCoffeeCup: (Int) -> Unit
) {
    var coffeeCupState by remember { mutableIntStateOf(coffeeGlassState) }

            Box(
            modifier = Modifier
                .alpha(if (coffeeCupState == 0) 1f else 0.3f)
                .clickable {
                    coffeeCupState = 0
                    outsideCoffeeCup(coffeeCupState)
                },
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                modifier = Modifier
                    .size(ImageMediumSize2),
                painter = painterResource(id = R.drawable.img),
                contentDescription = null
            )
            if (coffeeCupState == 0) {
                IconButton(
                    modifier = Modifier
                        .offset(x = MediumOffset1, y = MediumMinusOffset1)
                        .size(MediumIconSize1),
                    onClick = {},
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Orange)
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .alpha(if (coffeeCupState == 1) 1f else 0.3f)
                .clickable {
                    coffeeCupState = 1
                    outsideCoffeeCup(coffeeCupState)
                },
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                modifier = Modifier
                    .offset(y = MediumOffset1)
                    .size(ImageMediumSize2),
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = null
            )
            if (coffeeCupState == 1) {
                IconButton(
                    modifier = Modifier
                        .offset(x = ExtraSmallOffset2, y = MediumMinusOffset2)
                        .size(MediumIconSize1),
                    onClick = {},
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Orange)
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }
        }
}