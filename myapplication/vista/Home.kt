package com.example.myapplication.vista

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController){

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.DarkGray,
                        titleContentColor = Color.White,
                    ),
                    title = { Text(text = "CRUD") },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = "Localized description",
                                tint = Color.White
                            )
                        }
                    },
                )
            },
            bottomBar = {
                BottomAppBar (

                ){
                    Column(
                        modifier = Modifier
                            .width(138.dp)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ){
                        Image(
                            painter = painterResource(R.drawable.schedule_removebg_preview),
                            contentDescription = "shedule",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clickable(onClick = { navController.navigate(AppScreens.Home.route) })
                                .size(70.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .width(138.dp)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ){
                        Image(
                            painter = painterResource(R.drawable.home_removebg_preview),
                            contentDescription = "home",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clickable(onClick = { navController.navigate(AppScreens.Home.route) })
                                .size(70.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .width(138.dp)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ){
                        Image(
                            painter = painterResource(R.drawable.user_removebg_preview),
                            contentDescription = "user",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clickable(onClick = { navController.navigate(AppScreens.Home.route) })
                                .size(70.dp)
                        )
                    }
                }
            }
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                Box(
                    modifier = Modifier
                        .border(1.dp , Color.Black)
                        .fillMaxWidth()
                        .height(100.dp)
                        .wrapContentHeight()
                        .wrapContentSize()
                        .clickable(onClick = { navController.navigate(AppScreens.Create.route) })
                ){
                    Text("Creator", color = Color.Black, fontSize = 20.sp)
                }
                Box(
                    modifier = Modifier
                        .border(1.dp , Color.Black)
                        .fillMaxWidth()
                        .height(100.dp)
                        .wrapContentHeight()
                        .wrapContentSize()
                        .clickable(onClick = { navController.navigate(AppScreens.Read.route) })
                ){
                    Text("Reader", color = Color.Black, fontSize = 20.sp)
                }
                Box(
                    modifier = Modifier
                        .border(1.dp , Color.Black)
                        .fillMaxWidth()
                        .height(100.dp)
                        .wrapContentHeight()
                        .wrapContentSize()
                        .clickable(onClick = { navController.navigate(AppScreens.Update.route) })
                ){
                    Text("Updater", color = Color.Black, fontSize = 20.sp)
                }
                Box(
                    modifier = Modifier
                        .border(1.dp , Color.Black)
                        .fillMaxWidth()
                        .height(100.dp)
                        .wrapContentHeight()
                        .wrapContentSize()
                        .clickable(onClick = { navController.navigate(AppScreens.Delate.route) })
                ){
                    Text("Deleter", color = Color.Black, fontSize = 20.sp)
                }

            }
        }
    }
}