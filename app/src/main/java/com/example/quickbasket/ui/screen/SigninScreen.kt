package com.example.quickbasket.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickbasket.R

@Composable
fun SigninScreen(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .requiredWidth(390.dp)
            .requiredHeight(800.dp)
            .background(Color.White)
    ) {
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
            text = "Sign in",
            color = Color.Black,
            style = TextStyle(fontSize = 35.sp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 140.dp, y = 175.dp)
        )
        Text(
            text = "Email",
            color = Color.Black,
            style = TextStyle(fontSize = 15.sp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 40.dp, y = 285.dp)
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Enter your email address") },
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 31.dp, y = 308.dp)
                .requiredWidth(320.dp)
                .requiredHeight(52.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(Color.White)
                .border(BorderStroke(1.5.dp, Color(0xfff97300)), RoundedCornerShape(25.dp)),
            textStyle = TextStyle(color = Color.Black)
        )
        Text(
            text = "Password",
            color = Color.Black,
            style = TextStyle(fontSize = 15.sp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 40.dp, y = 370.dp)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Enter your password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 31.dp, y = 392.dp)
                .requiredWidth(320.dp)
                .requiredHeight(52.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(Color.White)
                .border(BorderStroke(1.5.dp, Color(0xfff97300)), RoundedCornerShape(25.dp)),
            textStyle = TextStyle(color = Color.Black)
        )
        Text(
            text = "Don’t have an account?",
            color = Color.Black,
            style = TextStyle(fontSize = 12.sp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 90.dp, y = 458.dp)
        )
        Button(
            onClick = { /* Handle sign up click */ },
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 210.dp, y = 442.dp)
        ) {
            Text(
                text = "Sign up",
                color = Color(0xfff97300),
                style = TextStyle(fontSize = 12.sp)
            )
        }
        Button(
            onClick = { /* TODO Handle sign in click */ },
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xfff97300)),
            contentPadding = PaddingValues(horizontal = 41.dp, vertical = 4.dp),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 509.dp)
        ) {
            Text(
                text = "Sign in",
                color = Color.White,
                style = TextStyle(fontSize = 15.sp)
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun SigninScreenPreview() {
    SigninScreen()
}
