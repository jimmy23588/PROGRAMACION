package com.example.imagentexto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.imagentexto.ui.theme.ImagenTextoTheme

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
@Preview
@Composable
fun MostrarImagen() {
    Image(modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.img),
        contentDescription = "La vida",

    )
    Text(modifier = Modifier
        , text="la vida es una sola",
        color = colorResource(id = R.color.purple_200),
        fontSize = 15.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.ExtraBold,
    )


        //solo en una linea
}