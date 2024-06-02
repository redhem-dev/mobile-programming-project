package com.example.quickbasket.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.quickbasket.R
import com.example.quickbasket.ui.screen.navigation.NavigationDestination
import com.example.quickbasket.ui.theme.*

object SingleProductDestination : NavigationDestination {
    override val route = "singleProduct"
    override val title = "SingleProduct"
}

@Composable
fun SingleProductPage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 360.dp)
            .requiredHeight(height = 800.dp)
            .background(color = Color.White)

    ) {

        Text(
            text = "Bananas",
            color = Color.Black,
            style = TextStyle(
                fontSize = 20.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 139.5.dp,
                    y = 25.dp
                )
                .wrapContentHeight(align = Alignment.CenterVertically))
        Image(
            painter = painterResource(id = R.drawable.bananas),
            contentDescription = "bananas 1",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 40.dp,
                    y = 65.dp
                )
                .requiredWidth(width = 280.dp)
                .requiredHeight(height = 191.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .border(
                    border = BorderStroke(3.dp, Color(0xfff97300)),
                    shape = RoundedCornerShape(20.dp)
                ))
        Text(
            text = "Indulge in the rich, creamy goodness of our premium bananas. Sourced from the finest growers, our bananas are meticulously selected for their perfect ripeness, ensuring a sweet and satisfying taste with every bite. Packed with nutrients and bursting with flavor, our bananas are the perfect choice for a healthy and delicious snack.",
            color = Color.Black,
            textAlign = TextAlign.Center,
            lineHeight = 1.4.em,
            style = TextStyle(
                fontSize = 15.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 43.5.dp,
                    y = 280.8280029296875.dp
                )
                .requiredWidth(width = 273.dp)
                .wrapContentHeight(align = Alignment.CenterVertically))
        Button(
            onClick = { /*TODO add click function*/ },
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(Orange),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 50.dp,
                    y = 571.8280029296875.dp
                )
                .requiredWidth(width = 260.dp)
                .requiredHeight(height = 45.dp)
        ) {
            Text(
                text = "Add to cart",
                color = Color.White,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 15.sp),
                modifier = Modifier
                    .border(border = BorderStroke(0.4000000059604645.dp, Color.White)))
        }
        Row (
            modifier = Modifier
                .align(Alignment.Center)
                .offset(
                    y = 180.dp
                )
        ){
            Text(
                text = "Price: $4", // TODO pull from db
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp),
                modifier = Modifier
                    .padding(25.dp)
                    .align(alignment = Alignment.Bottom)

                    .wrapContentHeight(align = Alignment.CenterVertically))


            Text(
                text = "Quantity: 1", // TODO pull from db
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp),
                modifier = Modifier
                    .padding(25.dp)
                    .align(alignment = Alignment.Bottom)

                    .wrapContentHeight(align = Alignment.CenterVertically))
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun SingleProductPagePreview() {
    SingleProductPage(Modifier)
}