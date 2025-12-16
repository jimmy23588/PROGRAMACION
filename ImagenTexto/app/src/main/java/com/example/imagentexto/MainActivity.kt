package com.example.imagentexto


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.imagentexto.ui.theme.ImagenTextoTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
import com.example.imagentexto.R.color.black
import java.time.Clock.offset
import kotlin.random.Random
//para que funcione el offset se define un objeto Saver
val OffsetSaver = Saver<Offset, Pair<Float, Float>>(
    save = { Pair(it.x,it.y)}, //guardar los pares de float
    restore ={(x,y)-> Offset(x,y)}//restaurar a Offset
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImagenTextoTheme {
                MostrarImagen()
                }
            }
        }
    }
@Preview(showBackground = true)
@Composable
fun MostrarImagen() {
    //declaramos una variable observable para almacenar el color de fondo
    //var colorFondo: Color by remember { mutableStateOf(android.R.color.white)}
     //var colorFondo by remember { mutableStateOf(Color.White) }
    var colorFondoInt by rememberSaveable {mutableStateOf(Color.Blue.toArgb())}
    var colorFondo = Color(colorFondoInt)
    var posicionTexto by rememberSaveable (stateSaver = OffsetSaver){ mutableStateOf(Offset(0f,0f)) }
    //calculamos el alto y ancho de la pantalla
    var anchoPantalla by rememberSaveable { mutableStateOf(0f) }
    var altoPantalla by rememberSaveable { mutableStateOf(0f) }
    //calculamos alto y ancho del texto
    var anchoTexto by rememberSaveable { mutableStateOf(0f) }
    var altoTexto by rememberSaveable { mutableStateOf(0f) }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .background(colorFondo)
        .onGloballyPositioned{cordinates->
            altoPantalla = cordinates.size.height.toFloat()
            anchoPantalla=cordinates.size.width.toFloat()
            //if (posicionTexto.x==0 && posicionTexto.y==0)
            /*if (posicionTexto==Offset(0f,0f))
                posicionTexto = Offset(anchoPantalla/2,altoPantalla/2)*/


        }
    )
    {
        /*Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "La vida",
            modifier = Modifier.align(Alignment.Center).fillMaxSize()

            )*/
        //imagenInterativa
        imagenInteractiva()
        Text(
            text="la vida es una sola",
            color = colorResource(id = R.color.teal_700),
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            //modifier = Modifier.align(Alignment.Center)
            modifier = Modifier
                .onGloballyPositioned{cordinates ->
                    anchoTexto=cordinates.size.width.toFloat()
                    altoTexto=cordinates.size.height.toFloat()
                    if (posicionTexto==Offset(0f,0f)){
                        posicionTexto=Offset((anchoPantalla-anchoTexto)/2
                            ,(altoPantalla-altoTexto)/2)

                        }

                }
                .offset{IntOffset(posicionTexto.x.toInt(),posicionTexto.y.toInt())
                }
                .pointerInput(Unit){

                    detectDragGestures  { change ,dragAmount ->
                        change.consume() //evita que se activa otros eventos
                        posicionTexto= Offset(posicionTexto.x+dragAmount.x,
                            posicionTexto.y+dragAmount.y)
                    }
                }
        )
        Button( onClick = {colorFondoInt =ColorAleatorio().toArgb()}
            , modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text(text = "cambiar fondo")
        }


        }
    }
@Composable
fun imagenInteractiva(){
    //nesecitamos almacenar y observar la escala de la imagen
    var escala by rememberSaveable { mutableStateOf(1f) }
    //nesecitamos la posicion
    var posicion by rememberSaveable (stateSaver = OffsetSaver) { mutableStateOf(Offset.Zero) }
    //queremos rotar la imagen , para la variable rotacion angulo
    var rotacion by rememberSaveable { mutableStateOf(0f) }
    Box(modifier = Modifier.fillMaxSize()
        .pointerInput(Unit){
            detectTransformGestures {_, desplazamiento, zoom, rotacionAngulo ->
                posicion += desplazamiento //aplicamos el desplazamiento a la posicion
                //aplicamos el zoom a la escala
                escala *= zoom
                //aplicamos la rotacion
                rotacion +=rotacionAngulo

            }

        }//agregamos el click
        .pointerInput(key1 = Unit){
            detectTapGestures (onDoubleTap = null){
                escala = 1f //resetear el tamaño la escala
                posicion = Offset.Zero //resetear la poscion
                rotacion =0f //resetear la rotacion
            }

        }
        , contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "La vida",
            modifier = Modifier
                //graphicsLayer permite aplicar una escala y una posicion a la imagen
                .graphicsLayer(
                    //desplazamiento
                    translationX = posicion.x,
                    translationY = posicion.y,
                    //escala
                    scaleX = escala.coerceIn(0.5f,3f),//limite del zoom del eje x
                    scaleY = escala.coerceIn(0.5f,3f),
                    rotationZ = rotacion

                    //rotacion
                )

        )

    }


}

fun ColorAleatorio():Color{
    val rojo=kotlin.random.Random.nextFloat()
    //val rojoNuevo =(0..255) otra forma de hacer coloeres aleatorios
    val verde=kotlin.random.Random.nextFloat()
    val azul= kotlin.random.Random.nextFloat()

    return Color(rojo,verde,azul)

}



