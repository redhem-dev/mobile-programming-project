package com.example.quickbasket.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
fun SignupScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .requiredWidth(390.dp)
                .requiredHeight(844.dp)
                .background(Color.White)
        ) {
            IconButton(
                onClick = { /* Handle back button click */ },
                modifier = Modifier
                    .offset(x = 15.dp, y = 35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.goback_arrow),
                    contentDescription = "Back"
                )
            }

            Text(
                text = "Sign up",
                color = Color.Black,
                style = TextStyle(fontSize = 35.sp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
                    .offset(x=20.dp, y=40.dp)
            )
            Text(
                text = "Full name",
                color = Color.Black,
                style = TextStyle(fontSize = 15.sp),
                modifier = Modifier
                    .offset(x = 40.dp, y = 110.dp)
            )
            TextField(
                value = name,
                onValueChange = { name = it },
                placeholder = { Text("Enter your name") },
                modifier = Modifier
                    .offset(x = 31.dp, y = 115.dp)
                    .requiredWidth(320.dp)
                    .requiredHeight(52.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color.White)
                    .border(BorderStroke(1.5.dp, Color(0xfff97300)), RoundedCornerShape(25.dp)),
                textStyle = TextStyle(color = Color.Black)
            )
            Text(
                text = "Email",
                color = Color.Black,
                style = TextStyle(fontSize = 15.sp),
                modifier = Modifier
                    .offset(x = 40.dp, y = 120.dp)
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Enter your email address") },
                modifier = Modifier

                    .offset(x = 31.dp, y = 122.dp)
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
                    .offset(x = 40.dp, y = 130.dp)
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Enter your password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .offset(x = 31.dp, y = 132.dp)
                    .requiredWidth(320.dp)
                    .requiredHeight(52.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color.White)
                    .border(BorderStroke(1.5.dp, Color(0xfff97300)), RoundedCornerShape(25.dp)),
                textStyle = TextStyle(color = Color.Black)
            )
            Text(
                text = "Repeat password",
                color = Color.Black,
                style = TextStyle(fontSize = 15.sp),
                modifier = Modifier
                    .offset(x = 40.dp, y = 140.dp)
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Enter your password again") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .offset(x = 31.dp, y = 142.dp)
                    .requiredWidth(320.dp)
                    .requiredHeight(52.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color.White)
                    .border(BorderStroke(1.5.dp, Color(0xfff97300)), RoundedCornerShape(25.dp)),
                textStyle = TextStyle(color = Color.Black)
            )

            Button(
                onClick = { /* Handle sign up click */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xfff97300)),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
                    .offset(x=0.dp, y=175.dp)
            ) {
                Text(
                    text = "Sign Up",
                    color = Color.White,
                    style = TextStyle(fontSize = 20.sp)
                )
            }

            Text(
                text = "Have an account?",
                color = Color.Black,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
                    .offset(x=(-40).dp, y=70.dp)
            )

            Button(
                onClick = { /* Handle log in click */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier

                    .padding(top = 8.dp)
                    .offset(x=190.dp, y=29.dp)
            ) {
                Text(
                    text = "Log In",
                    color = Color(0xfff97300),
                    style = TextStyle(fontSize = 14.sp)
                )
            }
        }
    }
}
@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun SignupScreenPreview() {
    SignupScreen()
}
