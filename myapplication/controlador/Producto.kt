package com.example.myapplication.controlador

class Producto(
    val idProducto:String,
    val nombre:String,
    val precio:Int
) {

    constructor(): this("","",0)

}