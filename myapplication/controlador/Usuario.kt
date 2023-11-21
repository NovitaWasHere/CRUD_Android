package com.example.myapplication.controlador


data class Usuario(

    var idUsuario:String,
    var nombre:String,
    var apellido:String,
    var anos:String,

) {

        constructor(): this("","","","")


    override fun toString(): String {
        return "Usuario(idUsuario='$idUsuario', nombre='$nombre', apellido='$apellido', anos=$anos)"
    }


}
