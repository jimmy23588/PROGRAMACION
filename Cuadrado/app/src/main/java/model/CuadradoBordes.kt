package model

import android.graphics.Color
//por defecto todas las clases son finale por cambiar a open
class CuadradoBordes( color: Int, ancho: Int, alto: Int, var bordeColor: Int = Color.BLACK):Cuadrado(color,ancho,alto)  {
        //metodo nuevo que tengo que añadir cambiar color borde
        fun cambiarColorBorde(nuevoColorBorde: Int){
            bordeColor = nuevoColorBorde
        }
    //  ejemplo de clase nested
    class ManejoColor{
        // definimos un obejeto comun a toda la clase que son colores
        companion object {
            val ROJO = Color.RED
            val AZUL = Color.BLUE

            //val AMARILLO = Color.YELLOW
            val VERDE = Color.GREEN
            val NEGRO = Color.BLACK

        //DEFINIMOS EL METODO DE CAMBIAR COLOR
        fun obtenerCuatroColoresAleatorio(): Int{
            //creamos una lista de colores
            val colores = listOf (ROJO,AZUL,VERDE,NEGRO)
            return  colores.random()

        }
        }


    }



}