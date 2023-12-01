package com.example.myapplication.vista

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.controlador.Producto
import com.example.myapplication.controlador.Usuario
import com.example.myapplication.nagivation.AppScreens
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Update(navController: NavController){

    val db = Firebase.firestore

    var Usuario by remember { mutableStateOf<Usuario?>(null) }
    var Producto by remember { mutableStateOf<Producto?>(null) }
    var clave by remember { mutableStateOf("") }

    //Usuario
    var usuarioNombre by remember { mutableStateOf("") }
    var usuarioApellido by remember { mutableStateOf("") }
    var usuarioAnos by remember { mutableStateOf("") }

    //Producto
    var productoNombre by remember { mutableStateOf("") }
    var productoPrecio by remember { mutableStateOf("") }

    var desaparecer by remember { mutableStateOf(false) }
    var NumberApear by remember { mutableStateOf(0) }
    var usuario by remember { mutableStateOf(0) }
    var producto by remember { mutableStateOf(0) }
    var botones by remember { mutableStateOf(0) }

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
            if(botones == 0 ){

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .wrapContentSize()
                        .wrapContentWidth()
                        .background(Color.White),
                    contentPadding = PaddingValues(100.dp)
                ){
                    items(1){
                        Button(
                            onClick =  { usuario = 1
                                botones = 1},
                            modifier = Modifier
                                .size(width = 180.dp, height = 80.dp)
                        )
                        {
                            Text("Usuarios", color = Color.White)
                        }
                        Spacer(modifier = Modifier.size(50.dp))
                    }
                    items(1){
                        Button(
                            onClick =  { producto = 1
                                botones = 1},
                            modifier = Modifier
                                .size(width = 180.dp, height = 80.dp)
                        )
                        {
                            Text("Productos", color = Color.White)
                        }
                    }
                }
            }
            if(usuario == 1){

                if (NumberApear == 1) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(),
                        contentPadding = PaddingValues(100.dp)
                    ) {
                        items(1) {
                            TextField(
                                value = usuarioNombre,
                                onValueChange = { usuarioNombre = it },
                                label = { Text("Nombre") }
                            )
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                        items(1) {
                            TextField(
                                value = usuarioApellido,
                                onValueChange = { usuarioApellido = it },
                                label = { Text("Apellido") }
                            )
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                        items(1) {
                            TextField(
                                value = usuarioAnos,
                                onValueChange = { usuarioAnos = it },
                                label = { Text("Años") },
                                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                            )
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                        items(1){
                            Button(
                                onClick = {
                                    Log.d("print", usuarioNombre)
                                    Log.d("print", usuarioApellido)
                                    Log.d("print", usuarioAnos)
                                    db.collection("Usuario").document(clave)
                                        .update(
                                            mapOf(
                                                "nombre" to usuarioNombre,
                                                "apellido" to usuarioApellido,
                                                "anos" to usuarioAnos,
                                            )
                                        )
                                        .addOnSuccessListener {
                                            Log.d(TAG, "DocumentSnapshot successfully updated!")
                                            desaparecer = true
                                            NumberApear = 2
                                        }
                                        .addOnFailureListener { e ->
                                            Log.w(ContentValues.TAG, "Error adding document", e)
                                            Log.d("print", usuarioNombre)
                                            Log.d("print", usuarioApellido)
                                            Log.d("print", usuarioAnos)
                                        }
                                        .addOnFailureListener({ "dasasaddsa" })
                                },
                                modifier = Modifier.size(width = 180.dp, height = 80.dp)
                            ) {
                                Text("submit", color = Color.White)
                            }
                        }
                    }
                }else if(NumberApear == 2){

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .wrapContentSize()
                            .wrapContentWidth()
                            .background(Color.White),
                        contentPadding = PaddingValues(100.dp)
                    ) {
                        items(1){
                            Column() {
                                Row(){
                                    Text("Se ha actualizado el usuario correctamente ", color = Color.Black, textAlign = TextAlign.Center,
                                        style = MaterialTheme.typography.titleLarge)
                                }
                                Row(){
                                    Text("ID = $clave ", color = Color.Black, textAlign = TextAlign.Center,
                                        style = MaterialTheme.typography.titleLarge)
                                }
                            }
                            Spacer(modifier = Modifier.size(50.dp))
                        }
                        items(1){
                            Button(onClick = {navController.navigate(AppScreens.Home.route)},
                                modifier =  Modifier.size(width = 200.dp,height = 80.dp)){
                                Text("OK", color = Color.White)
                            }
                        }

                    }


                }else if(!desaparecer){

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                    ){
                        Box(modifier = Modifier .fillMaxWidth()
                            .wrapContentSize()){
                            Text("User Id to Modifie:", color = Color.Black,textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.titleLarge)
                            Spacer(modifier = Modifier.size(50.dp))
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentSize()
                        ) {
                            TextField(
                                value = clave,
                                onValueChange = { clave = it },
                                label = { Text("clave") }
                            )
                        }
                        Spacer(modifier = Modifier.size(50.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentSize()
                        ){
                            Button(
                                onClick = {
                                    Log.d("Usuario", clave)
                                    val docRef = db.collection("Usuario").document(clave)
                                    docRef.get().addOnSuccessListener { documentSnapshot ->
                                        Usuario = documentSnapshot.toObject<Usuario>()
                                        Log.d("Usuario", documentSnapshot.data.toString())
                                        Log.d("print", Usuario.toString())
                                        usuarioNombre = Usuario?.nombre.toString()
                                        usuarioApellido = Usuario?.apellido.toString()
                                        usuarioAnos = Usuario?.anos.toString()
                                        desaparecer = true
                                        Log.d("print", clave)
                                        Log.d("print", usuarioNombre)
                                        Log.d("print", usuarioApellido)
                                        Log.d("print", usuarioAnos)
                                        Log.d("print", desaparecer.toString())
                                        NumberApear = 1

                                    }
                                        .addOnFailureListener({"dasasaddsa"})
                                }
                                ,
                                modifier =  Modifier.size(width = 180.dp,height = 80.dp)
                            ){
                                Text("submit", color = Color.White)
                            }
                        }
                    }
                }

            }else if(producto == 1){
                if (NumberApear == 1) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(),
                    contentPadding = PaddingValues(100.dp)
                ) {
                    items(1) {
                        TextField(
                            value = productoNombre,
                            onValueChange = { productoNombre = it },
                            label = { Text("Nombre") }
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                    }
                    items(1) {
                        TextField(
                            value = productoPrecio,
                            onValueChange = { productoPrecio = it },
                            label = { Text("Precio") }
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                    }
                    items(1){
                        Button(
                            onClick = {
                                Log.d("print", productoNombre)
                                Log.d("print", productoPrecio)
                                db.collection("Producto").document(clave)
                                    .update(
                                        mapOf(
                                            "nombre" to productoNombre,
                                            "precio" to productoPrecio
                                        )
                                    )
                                    .addOnSuccessListener {
                                        Log.d(TAG, "DocumentSnapshot successfully updated!")
                                        desaparecer = true
                                        NumberApear = 2
                                    }
                                    .addOnFailureListener { e ->
                                        Log.w(ContentValues.TAG, "Error adding document", e)
                                        Log.d("print", productoNombre)
                                        Log.d("print", productoPrecio)
                                    }
                                    .addOnFailureListener({ "dasasaddsa" })
                            },
                            modifier = Modifier.size(width = 180.dp, height = 80.dp)
                        ) {
                            Text("submit", color = Color.White)
                        }
                    }
                }
            }else if(NumberApear == 2){

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .wrapContentSize()
                        .wrapContentWidth()
                        .background(Color.White),
                    contentPadding = PaddingValues(100.dp)
                ) {
                    items(1){
                        Column() {
                            Row(){
                                Text("Se ha actualizado el producto correctamente ", color = Color.Black, textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.titleLarge)
                            }
                            Row(){
                                Text("ID = $clave ", color = Color.Black, textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.titleLarge)
                            }
                        }
                        Spacer(modifier = Modifier.size(50.dp))
                    }
                    items(1){
                        Button(onClick = {navController.navigate(AppScreens.Home.route)},
                            modifier =  Modifier.size(width = 200.dp,height = 80.dp)){
                            Text("OK", color = Color.White)
                        }
                    }

                }


            }else if(!desaparecer){

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                ){
                    Box(modifier = Modifier .fillMaxWidth()
                        .wrapContentSize()){
                        Text("Product Id to Modifie:", color = Color.Black,textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge)
                        Spacer(modifier = Modifier.size(50.dp))
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize()
                    ) {
                        TextField(
                            value = clave,
                            onValueChange = { clave = it },
                            label = { Text("clave") }
                        )
                    }
                    Spacer(modifier = Modifier.size(50.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize()
                    ){
                        Button(
                            onClick = {
                                Log.d("Producto", clave)
                                val docRef = db.collection("Producto").document(clave)
                                docRef.get().addOnSuccessListener { documentSnapshot ->
                                    Producto = documentSnapshot.toObject<Producto>()
                                    Log.d("Producto", documentSnapshot.data.toString())
                                    Log.d("print", Producto.toString())
                                    productoNombre = Producto?.nombre.toString()
                                    productoPrecio = Producto?.precio.toString()
                                    desaparecer = true
                                    Log.d("print", clave)
                                    Log.d("print", productoNombre)
                                    Log.d("print", productoPrecio)
                                    NumberApear = 1

                                }
                                    .addOnFailureListener({"dasasaddsa"})
                            }
                            ,
                            modifier =  Modifier.size(width = 180.dp,height = 80.dp)
                        ){
                            Text("submit", color = Color.White)
                        }
                    }
                }
            }

        }
        }
    }
}