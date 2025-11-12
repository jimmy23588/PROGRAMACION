package com.example.miprimerjetpackcompose

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //MiPrimeraComposable()
            MiSegundaComposable()




        }
    }
}
@Composable
fun MiSegundaComposable(){
    Box(modifier = Modifier.fillMaxSize().padding(20.dp),
        contentAlignment = Alignment.Center){
        Text(text="pepito", modifier = Modifier.align(Alignment.TopStart))
        //Spacer(modifier = Modifier.width(35.dp))
        Text(text="antonio garcia", modifier = Modifier.align(Alignment.TopCenter))
        Text(text="puma", modifier = Modifier.align(Alignment.TopEnd))
    }
}
@Composable
fun MiTerceraComposable(){
    Box(modifier = Modifier.fillMaxSize().padding(20.dp),
        contentAlignment = Alignment.Center){
        Text(text="pepito", modifier = Modifier.align(Alignment.TopStart))
        Text(text="pepito", modifier = Modifier.align(Alignment.TopCenter))
        Text(text="pepito", modifier = Modifier.align(Alignment.TopEnd))
        //Spacer(modifier = Modifier.width(35.dp))
        Text(text="antonio garcia", modifier = Modifier.align(Alignment.Center))
        Text(text="antonio garcia", modifier = Modifier.align(Alignment.CenterStart))
        Text(text="antonio garcia", modifier = Modifier.align(Alignment.CenterEnd))
         //
        Text(text="antonio garcia", modifier = Modifier.align(Alignment.BottomStart))
        Text(text="antonio garcia", modifier = Modifier.align(Alignment.BottomCenter))
        Text(text="antonio garcia", modifier = Modifier.align(Alignment.BottomEnd))
    }
}



/*@Composable
fun MiPrimeraComposable(holo_blue_bright: Int) {
    Column (modifier = Modifier.fillMaxSize().padding(top = 40.dp)){
    Row{
        Text(text="mi primera fila", modifier =  Modifier.background(Color=R.color.purple_700))
        Spacer(modifier = Modifier.width(35.dp))
        Text(text="segunda fila")
    }
     Spacer(modifier = Modifier.height(45.dp))
            Text(   text ="esta es mi primera funcion")
            Text (text = "aqui escribimos la segunda linea"  )
        }
}*/




/*@Preview(showBackground = true)
@Composable
fun MiPrimeraComposablePreview(){
    MiPrimeraComposable()
}*/
@Preview(showBackground = true)
@Composable
fun MiSegundaComposablePreview(){
    MiSegundaComposable()
}
@Preview(showBackground = true)
@Composable
fun MiTerceraComposablePreview(){
    MiTerceraComposable()
}





/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiPrimerJetPackComposeTheme {
        Greeting("jimmy")
    }
}
@Preview(showBackground = false,backgroundColor = R.color.holo_blue_bright.toLong() .toLong())
@Composable
fun GreetingPreview1() {
    MiPrimerJetPackComposeTheme {
        Greeting("jimmy1")
    }
}*/