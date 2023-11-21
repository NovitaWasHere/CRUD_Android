package com.example.myapplication.nagivation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.vista.Create
import com.example.myapplication.vista.Delate
import com.example.myapplication.vista.Home
import com.example.myapplication.vista.Login
import com.example.myapplication.vista.Read
import com.example.myapplication.vista.Update

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Login.route) {
        composable(AppScreens.Login.route) {
            Login(navController)
        }
        composable(AppScreens.Home.route) {
            Home(navController)
        }
        composable(AppScreens.Create.route) {
            Create(navController)
        }
        composable(AppScreens.Read.route) {
            Read(navController)
        }
        composable(AppScreens.Update.route) {
            Update(navController)
        }
        composable(AppScreens.Delate.route) {
            Delate(navController)
        }
    }
}