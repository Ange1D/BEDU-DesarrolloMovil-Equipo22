/**
 * Copyright (c) 2021.
 * @Author: Equipo 22.
 * @members: JOSE BERNAL FONSECA; ANGEL OMAR GOMEZ CASTILLO; BRAULIO DAVID HERNANDEZ PALAGOT.
 * @Topic: Desarrollo Móvil con Android: Kotlin Fundamentals.
 * @Project: Proyecto Guía: ChronoMaster 2021.
 */

package Proyecto

class Validaciones {
    fun entero(Mensaje:String):Int{
        return try {
            print("\t $Mensaje")
            //Si es null vuelve a llamar a la funcion
            return Integer.valueOf(readLine()) ?: entero(Mensaje)
        } catch (e: Exception) {
            //Si no es entero vulve a llamar a la funcion
            println("No es un numero valido")
            entero(Mensaje)
        }
    }

    fun texto(Mensaje:String):String{
            print("\t $Mensaje")
            //Si es null vuelve a llamar a la funcion
            return readLine()?.ifBlank { null } ?: texto("\nNo puede dejar el campo vacio $Mensaje")

    }
}