package com.example.myapplication.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.nagivation.AppScreens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController){
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.logods),
            contentDescription = "logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)

        )
        var nombre by remember { mutableStateOf("") }
        var contrasena by remember { mutableStateOf("") }
        Spacer(Modifier.size(50.dp))
        Text("USER :", color = Color.Black, fontSize = 22.sp)
        Spacer(Modifier.size(10.dp))
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Name") }
        )
        Spacer(Modifier.size(50.dp))
        Text("PASSWORD :", color = Color.Black, fontSize = 22.sp , textAlign = TextAlign.Left)
        Spacer(Modifier.size(10.dp))
        TextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Password") }
        )
        Spacer(Modifier.size(70.dp))
        Button(
            onClick = { navController.navigate(AppScreens.Home.route)},
            modifier =  Modifier.size(width = 180.dp,height = 80.dp),

        ) {
            Text("Log in" , fontSize = 22.sp)
        }
    }
}