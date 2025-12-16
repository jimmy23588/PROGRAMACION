package com.example.appbeer.ui.pantallas

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appbeer.data.RepositorioBeer

@Composable
fun PantallaDetalleBeer(navController: NavController,id:Int){
    //creamos variable beer donde almacenamos el objeto beer que se tiene que cargar segun el id
    //la beer esta en el fichero de datos en ubjeto beer en el objeto repositorio beer
    //para evitar errores de ids no valido , se pone que no devuelva nada "return"
    val beer = RepositorioBeer.getBeerById(id)?:return

    Column (modifier = Modifier.fillMaxSize().padding(16.dp)){
        Spacer(modifier= Modifier.height(8.dp))
        Button(onclick={navController.popBackStack()},modifier=Modifier.align(Alignment.Start)

        ){
            Text("Volver")

        }
        Spacer(modifier= Modifier.height(8.dp))
        Text(beer.nombre, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(
            Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(12.dp))
        //para poner anomaciones a la imagen se mete en un box
        Box(modifier = Modifier.fillMaxSize().height(300.dp),
            contentAlignment = Alignment.Center ){
            Image(painter = painterResource(id=beer.imagen),
                contentDescription = beer.nombre)
        }
        Spacer(modifier= Modifier.height(24.dp))


    }
}