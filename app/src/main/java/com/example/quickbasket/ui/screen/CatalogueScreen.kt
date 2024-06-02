package com.example.quickbasket.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.sp
import com.example.quickbasket.R
import com.example.quickbasket.ui.theme.Orange

// zasad sve banane
@Composable
fun CatalogueScreen(modifier : Modifier = Modifier) {


    Box(
        modifier
            .fillMaxSize()
            .background(Orange)
    ){

        IconButton(
            onClick = { /* TODO Handle back button click */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 16.dp, y = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.goback_arrow),
                contentDescription = "Back",
                tint = Color.Black
            )
        }
        Text(
            text = "Catalogue",
            color = Color.Black,
            style = TextStyle(
                fontSize = 30.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 120.5.dp,
                    y = 19.dp
                )
                .wrapContentHeight(align = Alignment.CenterVertically))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier.padding(
                top = 80.dp)
        ) {
            items(10) {
                ProductItem(modifier = Modifier.padding(8.dp))
            }
        }
    }
}


@Composable
fun ProductItem(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        modifier = modifier
            .clip(shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp))
            .requiredWidth(width = 150.dp)
            .border(
                BorderStroke(1.dp, Color.Black),
                shape = RoundedCornerShape(
                    bottomStart = 15.dp,
                    bottomEnd = 15.dp,
                    topStart = 15.dp,
                    topEnd = 15.dp
                )
            )
    ) {
        Column(
            modifier = Modifier
                .requiredHeight(height = 200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bananas),
                contentDescription = "product image",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .requiredWidth(width = 150.dp)
                    .requiredHeight(height = 100.dp)
                    .border(
                        BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                    )
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .requiredWidth(width = 150.dp)
                    .requiredHeight(height = 97.dp)
                    .background(color = Color.Black)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
            ) {
                Text(
                    text = "Bananas",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 15.sp))
                Text(
                    text = "$4",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 10.sp))
                Button(
                    onClick = { /*TODO add functionality*/ },
                    colors = ButtonDefaults.buttonColors(Orange)
                ){
                    Text(
                        text = "Add to cart",
                        modifier
                            .requiredWidth(width = 70.dp)
                            .requiredHeight(height = 30.dp)
                        
                    )
                }
            }
        }
    }
}

@Preview(widthDp = 150, heightDp = 197)
@Composable
private fun ProductItemPreview() {
    ProductItem(Modifier)
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun CatalogueScreenPreview() {
    CatalogueScreen()
}