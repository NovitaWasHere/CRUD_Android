package com.example.myapplication.nagivation

sealed class AppScreens(val route: String) {

    object Login: AppScreens("Login")
    object Home: AppScreens("Home")
    object Create: AppScreens("Create")
    object Read: AppScreens("Read")
    object Update: AppScreens("Update")
    object Delate: AppScreens("Delate")

}
