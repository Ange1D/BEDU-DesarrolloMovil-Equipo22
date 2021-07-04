/**
 * Copyright (c) 2021.
 * @Author: Equipo 22.
 * @members: JOSE BERNAL FONSECA; ANGEL OMAR GOMEZ CASTILLO; BRAULIO DAVID HERNANDEZ PALAGOT.
 * @Topic: Desarrollo Móvil con Android: Kotlin Fundamentals.
 * @Project: Proyecto Guía: ChronoMaster 2021.
 */

package TDA

/*
AUTOR: BRAULIO DAVID HERNANDEZ PALAGOT.
DESCRIPCION: Se creó una clase llamada Usuario que servirá para almacenar los datos del usuario y la funcionalidad de
loggin, tanto para los datos de prueba que se estarán utilizando durante este proyecto guía, así como los datos de más
usuarios, pensando en la escalabilidad del proyecto.
*/

class Usuario(var nombre: String, var contrasenna: String, var tareasTotales: Int = 0, var tareasRealizadas: Int = 0) {
    //DESCRIPCION: init que mostrará los datos de inicio de sesión del usuario.
    init {
        println(
            "Datos de inicio de sesión:\n" +
                    "\tUsuario: ${this.nombre}.\n" +
                    "\tContraseña: ${this.contrasenna}."
        )
    }

    //DESCRIPCION: Función para validar el nombre de usuario y contraseña.
    fun loggin(nombre: String, contrasenna: String): Boolean {
        return nombre.equals(this.nombre) && contrasenna.equals(this.contrasenna)
    }

}