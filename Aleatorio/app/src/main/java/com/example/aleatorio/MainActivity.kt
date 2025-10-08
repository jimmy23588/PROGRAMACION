package com.example.aleatorio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val numeroIntroducido : EditText = findViewById( R.id.EntradaValor)
        val boton : Button = findViewById(R.id.miBoton)
        val mensajesalida : TextView = findViewById(R.id.SalidaValor)
        var numeroAleatorio  = Random.nextInt(1,11)
        var contador : Int =0

        boton.setOnClickListener {
            contador++
            //recogemos el valor

            val valorIntroducido = numeroIntroducido.text.toString().toIntOrNull()
            if(valorIntroducido==null) mensajesalida.text="debe introducir un valor"
            else if (numeroAleatorio<valorIntroducido) mensajesalida.text="mas bajo"
            else if (numeroAleatorio>valorIntroducido) mensajesalida.text="mas alto"
            else mensajesalida.text="bien. os has conseguido" + contador.toString() + "intentos"
            //else mensajesalida.text="bien. os has conseguido" + contador.toString() + "intentos"

        }

    }
}
