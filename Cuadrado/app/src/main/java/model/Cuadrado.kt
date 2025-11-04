package model

import kotlin.random.Random

open class Cuadrado (var color:Int, var ancho:Int, var alto:Int) {
    //coordenadas iniciales
    var x : Int=0
    var y : Int=0
    //metodos para mover -cambiar el cuadrado
    fun moverArriba(){
        y-=10 // y=  y-10
    }
    fun moverAbajo(){
        y+=10
    }
    fun moverDerecha(){
        x+=10
    }
    fun moverIzquierda(){
        x-=10
    }
    fun aumentarTamanio(){
        ancho+= 20
        alto += 20
    }
    fun disminuirTamaño(){
        ancho-= 20
        alto -= 20
    }
    fun cambiarRandon(){
        val random = Random.Default
        val ancho=random.nextInt(150,)
        val alto=random.nextInt( 255)


    }

}