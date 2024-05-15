package com.example.unicum.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.unicum.R
import com.example.unicum.domain.model.Coffee
import com.example.unicum.presentation.Dimens.CardHeightSize
import com.example.unicum.presentation.Dimens.CardWidthSize
import com.example.unicum.presentation.Dimens.ImageMediumSize1
import com.example.unicum.presentation.Dimens.MediumFontSize1
import com.example.unicum.presentation.Dimens.MediumFontSize2
import com.example.unicum.presentation.Dimens.MediumFontSize3
import com.example.unicum.presentation.Dimens.MediumPadding2
import com.example.unicum.presentation.Dimens.SmallPadding1
import com.example.unicum.presentation.Dimens.SmallShape1
import com.example.unicum.ui.theme.gradientCard
import com.example.unicum.ui.theme.gradientPrice
import com.example.unicum.utils.Constants.RUB

@Composable
fun CoffeeCard(
    coffee: Coffee,
    onClick: (Coffee) -> Unit
) {
    Card(
        modifier = Modifier
            .padding()
            .background(Color.Transparent),
        shape = RoundedCornerShape(SmallShape1),
        onClick = { onClick(coffee) }
    ) {
        Column(
            modifier = Modifier
                .size(width = CardWidthSize, height = CardHeightSize)
                .background(gradientCard),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (coffee.viewGlass) {
                0 -> Image(
                    modifier = Modifier
                        .size(ImageMediumSize1),
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = null
                )

                else -> Image(
                    modifier = Modifier
                        .size(ImageMediumSize1),
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = null
                )
            }
            Text(
                text = coffee.name,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = MediumFontSize1,
//                    fontFamily = FontFamily(Font(R.font.montserrat_regular))
                ),
                color = colorResource(id = R.color.name_text)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(gradientPrice),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(
                        start = MediumPadding2,
                        top = SmallPadding1,
                        bottom = SmallPadding1
                    ),
                    text = stringResource(id = R.string.v),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = MediumFontSize2,
//                    fontFamily = FontFamily(Font(R.font.montserrat_regular))
                    ),
                    color = colorResource(id = R.color.v_text)
                )
                if (!coffee.sellFree) {
                    Text(
                        modifier = Modifier.padding(end = MediumPadding2),
                        text = "${coffee.price} $RUB",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = MediumFontSize3,
//                    fontFamily = FontFamily(Font(R.font.montserrat_regular))
                        ),
                        color = colorResource(id = R.color.price_text)
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewCardCoffee() {
//    CoffeeCard(Coffee(
//        name = "Капучино эконом",
//        price = 199,
//        sellFree = false,
//        viewGlass = 1
//    ),
//        onClick = {})
//}