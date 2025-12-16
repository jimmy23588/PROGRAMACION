package com.example.appbeer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.appbeer.ui.pantallas.PantallaInicio
import com.example.appbeer.ui.theme.AppBeerTheme
import androidx.navigation.compose.composable
import com.example.appbeer.ui.pantallas.PantallaGaleria
import com.example.appbeer.ui.pantallas.PantallaInfo

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppBeerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    BeerApp() }
            }
        }
    }
}
@Composable
fun BeerApp(){
    //CREAMOS UNA VARIABLE
    val navController = rememberNavController()
    //creamos contenedor de navigacion : definir las rutas
    NavHost(navController = navController, startDestination = "inicio"
    ){
      composable("inicio"){PantallaInicio(navController)}
          composable("info"){ PantallaInfo(navController) }
        composable("galeria"){PantallaGaleria(navController)}



      }
}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppBeerTheme {
        Greeting("Android")
    }
}*/