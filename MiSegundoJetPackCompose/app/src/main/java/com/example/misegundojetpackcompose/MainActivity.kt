package com.example.misegundojetpackcompose

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.misegundojetpackcompose.ui.theme.MiSegundoJetPackComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiSegundoJetPackComposeTheme {
                Textos()

                //MiBoton()
               /* Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "JIMMY",
                        modifier = Modifier.padding(innerPadding)
                    )*/

                }
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiSegundoJetPackComposeTheme {
        Greeting("JIMMY")
    }

    }
@Composable
fun MiFuncion1(){
    Box(
        modifier= Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    )
    {
        Greeting("jimmy t.n",
            modifier = Modifier.background(Color.Yellow)
        )
        Greeting("android",
            modifier = Modifier.background(Color.Blue).align(Alignment.BottomEnd)
        )

    }
}
@Composable
fun MiFuncion2(){
    Column (
        modifier= Modifier
            .fillMaxWidth()
            .height(200.dp),
        //verticalArrangement = Arrangement.SpaceEvenly
        //verticalArrangement = Arrangement.SpaceBetween
        verticalArrangement = Arrangement.SpaceAround,
        Alignment.CenterHorizontally
    ){
        Greeting("jimmy t.n", modifier = Modifier.background(Color.Yellow).weight(2f))
        //Greeting("android", modifier = Modifier.background(Color.Blue))
        Greeting(" San Juan de la Cruz", modifier = Modifier.background(Color.Red).weight(1f))

    }
}
@Composable
fun MiFuncion3(){
    Row (modifier = Modifier
        .fillMaxWidth().height(200.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround

    ){
        Greeting("jimmy ", modifier = Modifier.background(Color.Yellow))
        Greeting("jimmy ", modifier = Modifier.background(Color.Magenta))


    }
}
//@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun MiBoton(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center


    ){
        Text(text = "Pulsa Aqui",
            modifier = Modifier
                .clickable{}
                .background(Color.Green)
                .border(width = 2.dp, color = Color.Magenta)
                .padding(horizontal = 20.dp ,vertical = 10.dp)


        )
    }
}
@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun Textos(){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text= stringResource(id=R.string.lore),
            color = colorResource(id = R.color.purple_200),
            fontSize = 15.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 2.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Right,
            lineHeight = 3.em,
            //solo en una linea
            maxLines = 2

            )
    }
}






//@Preview(showBackground = true)
@Composable
fun MiFuncion1Preview() {
    MiSegundoJetPackComposeTheme {
        MiFuncion1()
    }

}
//@Preview(showBackground = true)
/*@Composable
fun MiFuncion2Preview() {
    MiSegundoJetPackComposeTheme {
        MiFuncion2()
    }

}*/
//@Preview(showBackground = true)
@Composable
fun MiFuncion3Preview() {
    MiSegundoJetPackComposeTheme {
        MiFuncion3()
    }

}
//@Preview(showBackground = true)
@Composable
fun MiBotonPreview() {
    MiSegundoJetPackComposeTheme {
        MiBoton()
    }

}
