package com.example.appbeer.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appbeer.data.RepositorioBeer

@Composable
fun PantallaGaleria(navController: NavController){
    //lazyColumn que ocupe todo con margen (paddin) de 8
    LazyColumn(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        //empezamos a meter los elementos sacandolos de la lista
        items(RepositorioBeer.listaBeer.size){
            index:Int->val beer = RepositorioBeer.listaBeer[index]
            //con cada elemento de la lista meterlo en un card
            Card(modifier= Modifier.padding(8.dp).fillMaxWidth().clickable{}){
                Row(modifier =Modifier.padding(8.dp)){
                    //dentro ponemos la imagen , nombre,description
                    Image(painter = painterResource(id=beer.imagen),
                        contentDescription = beer.nombre,
                        modifier = Modifier.size(80.dp)
                        )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column (modifier = Modifier.weight(1f)){
                        Text(beer.nombre,style= MaterialTheme.typography.titleLarge)
                        //la descripcion solo queremos que se visualicen las 2 primeras lineas
                        Text(beer.descripcion,maxLines=2)
                    }
                }
            }
        }//hasta aqui vienes los items
        //boton tiene que estar dentro de un items
        item{
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {navController.popBackStack()},
                modifier =Modifier.fillMaxSize().padding(horizontal = 16.dp) ) {
                Text("Volver al inicio")
            }
        }
    }//lazycolumn
}