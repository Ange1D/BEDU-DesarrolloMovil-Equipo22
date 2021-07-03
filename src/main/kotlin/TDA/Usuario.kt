/**
 * Copyright (c) 2021.
 * @Author: Equipo 22.
 * @members: JOSE BERNAL FONSECA; ANGEL OMAR GOMEZ CASTILLO; BRAULIO DAVID HERNANDEZ PALAGOT.
 * @Topic: Desarrollo Móvil con Android: Kotlin Fundamentals.
 * @Project: Proyecto Guía: ChronoMaster 2021.
 */

package TDA

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

    //DESCRIPCION: En esta función se mostrarán los datos del usuario, con el objetivo de que pueda revisar cuántas tareas
    //tiene aún pendientes.
    fun resumenUsuario() {
        println(
            "---------------------------------------------\n" +
                    "Resumen del usuario:\n"
        )
        println(
            "\tNombre de usuario: ${this.nombre}.\n" +
                    "\tTareas totales: ${this.tareasTotales}.\n" +
                    "\tTareas finalizadas: ${this.tareasRealizadas}.\n" +
                    "\n\tTareas pendientes: ${this.tareasTotales - this.tareasRealizadas}"
        )
    }
}