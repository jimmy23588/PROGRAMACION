package com.example.mayordeedad

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.mayordeedad.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numero: EditText = findViewById<EditText>(R.id.editTextText)
        val boton: Button = findViewById<Button>(R.id.button)
        val vista: TextView = findViewById<TextView>(R.id.textView2)
        val boton2: Button = findViewById(R.id.button2)
        val boton3: Button = findViewById(R.id.button4)
        boton.setOnClickListener {
            // recoger el valor del campo texto , pasarlo a entero o null
            val numeroResultado = numero.text.toString().toIntOrNull()
            //actualizarMensaje(numeroResultado,vista)


            // poner un if pero hay que distingir si es nulo no
            /* if(numeroResultado== null)
                vista.text ="INTRODUZCA UN VALOR"
            else if (numeroResultado < 18)
                vista.text = "ERES MENOR DE EDAD"
            else if(numeroResultado>18)
                vista.text = "ERES MAYOR DE EDAD"
            else vista.text = "TIENES JUSTO 18 AÑOS"*/

            vista.text = if (numeroResultado == null) "INTRODUZCA UN VALOR"
            else if (numeroResultado < 18) "ERES MENOR DE EDAD"
            else if (numeroResultado > 18) "ERES MAYOR DE EDAD"
            else "tienes justo 18 años"
        }

        boton2.setOnClickListener {
            var numeroResultado = numero.text.toString().toIntOrNull()
            if (numeroResultado == null) vista.text = "introduce un valor"
            else numero.setText((++numeroResultado).toString())


        }
        boton3.setOnClickListener {
            var numeroResultado = numero.text.toString().toIntOrNull()
            if (numeroResultado == null) vista.text = "introduce un valor"
            else numero.setText((--numeroResultado).toString())

        }




    }
    private fun actualizarMensaje(edad: Int?, textoResultado: TextView) {
        val mensaje = when {
            edad == null -> "introduce un valor"
            edad < 18 -> "eres mayor de edad"
            edad > 18 -> "eres menor de edad"
            else -> "tienes justo 18"

        }
        textoResultado.text = mensaje


    }
}








