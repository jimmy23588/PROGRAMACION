package com.example.appbeer.data

import com.example.appbeer.R

data class Beer (val id: Int,val nombre: String, val imagen:Int,val descripcion:String)
object RepositorioBeer {
    val listaBeer =listOf(
        Beer(1,"Beer España", imagen = R.drawable.beer1,"Es una cerveza Española ,tipica de madrid de las mas consumidas  con un toque amargo y refrescante" ),
        Beer(2,"Beer Belga", imagen = R.drawable.beer2,"Es una cerveza  Belga muy suave con aromas a roble un leve toque amargo"),
        Beer(3,"Beer Alemana", imagen = R.drawable.beer3,"Es cerveza Alemana de un sabor fuerte y ligero ")
    )
    //funcion que devuelva la beer por id , si no encuentra la beer que devuelva null
    /*fun getBeerById(id: Int):Beer?{
        for (beer in listaBeer){
            if (beer.id==id){
                return  beer
            }
        }
        return null
    }*/

    fun getBeerById(id:Int):Beer?{
        return listaBeer.find{it.id==id}
    }
}