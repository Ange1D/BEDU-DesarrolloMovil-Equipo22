/**
 * Copyright (c) 2021.
 * @Author: Equipo 22.
 * @members: JOSE BERNAL FONSECA; ANGEL OMAR GOMEZ CASTILLO; BRAULIO DAVID HERNANDEZ PALAGOT.
 * @Topic: Desarrollo Móvil con Android: Kotlin Fundamentals.
 * @Project: Proyecto Guía: ChronoMaster 2021.
 */

package proyecto

class Validaciones {
    fun entero(Mensaje: String): Int {
        return try {
            print("\t $Mensaje")
            //Si es null vuelve a llamar a la funcion
            Integer.valueOf(readLine()) ?: entero(Mensaje)
        } catch (e: Exception) {
            //Si no es entero vulve a llamar a la funcion
            println("No es un numero valido")
            entero(Mensaje)
        }
    }

    fun texto(Mensaje: String): String {
        print("\t $Mensaje")
        //Si es null vuelve a llamar a la funcion
        return readLine()?.ifBlank { null } ?: texto("\nNo puede dejar el campo vacio\n\t $Mensaje")

    }

    fun enRango(Mensaje: String, minVal: Int, maxVal: Int): Int {
        //Se realiza la comprobación de que se introduzca un entero
        val lectura = entero(Mensaje)
        //Se revisa que el entero leído se encuentre en el rango correcto
        return if (lectura in minVal..maxVal)
            lectura
        else {
            //Si no está en el rango correcto, se vuelve a llamar a la función
            println("El dato no se encuentra en el rango establecido.")
            enRango(Mensaje, minVal, maxVal)
        }
    }
}