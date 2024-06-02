package com.example.quickbasket.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
import com.example.quickbasket.ui.screen.navigation.NavigationDestination

object ProfileDestination : NavigationDestination {
    override val route = "profile"
    override val title = "Profile"
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        IconButton(
            onClick = { /* TODO Handle back button click */ },
            modifier = Modifier
                .offset(x = 16.dp, y = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.goback_arrow),
                contentDescription = "Back",
                tint = Color.Black
            )
        }
        Text(
            text = "Your Profile",
            color = Color.Black,
            style = TextStyle(fontSize = 35.sp),
            modifier = Modifier
                .offset(y = 16.dp)
                .align(Alignment.TopCenter)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp), // Adjust this padding as needed
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_image),
                contentDescription = "image 6",
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(shape = RoundedCornerShape(100.dp)))
            Text(
                text = "Full name",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 15.sp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .wrapContentHeight(align = Alignment.CenterVertically))
            Text(
                text = "Username",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 15.sp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .wrapContentHeight(align = Alignment.CenterVertically))
            Text(
                text = "Email address",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 15.sp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .wrapContentHeight(align = Alignment.CenterVertically))
            Spacer(
                modifier = Modifier
                    .requiredHeight(height = 20.dp)
                    .background(color = Color.White))
            OutlinedButton(
                onClick = { /* TODO handle click navigate to edit profile page */ },
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xfff97300)),
                contentPadding = PaddingValues(horizontal = 41.dp, vertical = 4.dp),
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .requiredWidth(width = 153.dp)
                    .requiredHeight(height = 35.dp)
            )

            {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .requiredWidth(width = 153.dp)
                        .requiredHeight(height = 35.dp)
                ) {
                    Text(
                        text = "Edit profile",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 15.sp))
                }
            }
            OutlinedButton(
                onClick = { /* TODO handle click navigate to edit profile page */ },
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xfff97300)),
                contentPadding = PaddingValues(horizontal = 41.dp, vertical = 4.dp),
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .requiredWidth(width = 153.dp)
                    .requiredHeight(height = 35.dp)
            )

            {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .requiredWidth(width = 153.dp)
                        .requiredHeight(height = 35.dp)
                ) {
                    Text(
                        text = "Delete profile",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 15.sp))
                }
            }
            Text(
                text = "Need help?",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 15.sp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .wrapContentHeight(align = Alignment.CenterVertically))
            Text(
                text = "+01 23456789",
                color = Color(0xfff97300),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 10.sp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .requiredWidth(width = 71.dp)
                    .requiredHeight(height = 14.dp)
            )
            Text(
                text = "info@quickbasket.com",
                color = Color(0xfff97300),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 10.sp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .requiredWidth(width = 113.dp)
                    .requiredHeight(height = 15.dp))

        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun ProfilePagePreview() {
    ProfileScreen(Modifier)
}