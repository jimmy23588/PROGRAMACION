package com.example.cuadrado

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import model.CuadradoBordes
import kotlin.random.Random


//private val Cuadrado.bordeColor: Any

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        //identificacion de la vista
        val cuadradoView: View = findViewById(R.id.cuadrado)
        /*usamos el metodo post para que se ejecute este bloque de codigo en el hilo de l interface de usuario justo despues
        de que  cargar la vista , construya y se mida */

        cuadradoView.post {
            //variaables que recogen los datos de view inicial
            val inicialAncho = cuadradoView.width
            val inicialAlto = cuadradoView.height
            val inicialX: Int = cuadradoView.x.toInt()
            val inicialY: Int = cuadradoView.y.toInt()
            //asosciar la vista con el objeto cuadrado
            //contextcompac es una clase estatica
            /*val cuadrado: Cuadrado = Cuadrado(
                ContextCompat.getColor(this, R.color.red),
                inicialAncho,
                inicialAlto
            ).apply {
                //DAMOS  LOS VALORES DE x Y de la vista
                x = inicialX
                y = inicialY
            }*/
            val cuadrado: CuadradoBordes = CuadradoBordes(
                ContextCompat.getColor(this, R.color.red), inicialAncho,
                inicialAlto,
            ).apply {
                //DAMOS  LOS VALORES DE x Y de la vista
                x = inicialX
                y = inicialY
                bordeColor = ContextCompat.getColor(this@MainActivity,R.color.black)

            }


            //identificar de botones
            val buttontonArriba: Button = findViewById(R.id.buttonArriba)
            val buttonAbajo: Button = findViewById(R.id.buttonAbajo)
            val buttonDerecha: Button = findViewById(R.id.buttonDerecha)
            val buttonIzquierda: Button = findViewById(R.id.buttonIzquierda)
            val buttonTamanio: Button = findViewById(R.id.buttonCambiarTamanio)
            val buttonColor: Button = findViewById(R.id.buttonCambiarColor)
            val buttonDisminuirTamanio : Button= findViewById(R.id.buttonDisminuirTamanio)
            val buttonRandon :  Button = findViewById(R.id.buttonCambiarRandon)
            val buttonCambiarBordes : Button = findViewById(R.id.buttonCambiarBorde)

            //ponemos botones a la escucha
            buttontonArriba.setOnClickListener {
                cuadrado.moverArriba()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonAbajo.setOnClickListener {
                cuadrado.moverAbajo()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonDerecha.setOnClickListener {
                cuadrado.moverDerecha()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonIzquierda.setOnClickListener {
                cuadrado.moverIzquierda()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonTamanio.setOnClickListener {
                 cuadrado.aumentarTamanio()
                 //cuadrado.disminuirTamaño()

                actualizarVista(cuadrado, cuadradoView)

            }
            buttonColor.setOnClickListener {
                //cuadrado.color= ContextCompat.getColor(this,R.color.blue)
                cuadrado.color = generarColorAleatorio()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonDisminuirTamanio.setOnClickListener {
                cuadrado.disminuirTamaño()
                actualizarVista(cuadrado, cuadradoView)

            }
            buttonRandon.setOnClickListener {
                cuadrado.cambiarRandon()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonCambiarBordes.setOnClickListener {
              // cuadrado.cambiarColorBorde(generarColorAleatorio())
                //actualizarVista(cuadrado,cuadradoView)
                //lamamos a la clase nested
                cuadrado.cambiarColorBorde(CuadradoBordes.ManejoColor.obtenerCuatroColoresAleatorio())
                actualizarVista(cuadrado,cuadradoView)
            }




        }//post
    }





    //fuera del oncreate

    private fun generarColorAleatorio():Int{
        //generer 3 numeros aleatorio R , G , B E ENTRE 0 Y 255 INCLUIDO
        //creamos una variable randomcon Random.Defaul que garantiza mas compatibilidad
        val random = Random.Default
        val rojo=random.nextInt(256)
        val verde=random.nextInt(256)
        val azul= random.nextInt(256)
        // colo es la clase para almacenar colores rgb() saca el numero
        return Color.rgb(rojo,verde,azul)

    }
    private fun actualizarVista(cuadrado: CuadradoBordes,cuadradoView:View){
        //aqui es donde elazamos la vista con el objeto
        //la vista se actalixara su ancho y alto con los datos del objeto
        cuadradoView.layoutParams.width=cuadrado.ancho
        cuadradoView.layoutParams.height=cuadrado.alto
        //cambiar color
       // cuadradoView.setBackgroundColor(cuadrado.color)
        //actualizar las coordenadas
        cuadradoView.x=cuadrado.x.toFloat()
        cuadradoView.y=cuadrado.y.toFloat()
        //cambiamos el color de fondo y borde
        val drawable : GradientDrawable= GradientDrawable()
        drawable.setColor(cuadrado.color)
        drawable.setStroke(10,cuadrado.bordeColor)
        //asiganms la vista
        cuadradoView.background = drawable

        //aplicar o ejecutar  los cambios
        cuadradoView.requestLayout()

    }
    /*fun cambiarRandon(cuadrado: cambiarRandon ,cuadradoView:View){
        val random = Random.Default
        val ancho=random.nextInt(150,)
        val alto=random.nextInt( 250)


     }*/


}

