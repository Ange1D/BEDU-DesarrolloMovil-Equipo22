/**
 * Copyright (c) 2021.
 * @Author: Equipo 22.
 * @members: JOSE BERNAL FONSECA; ANGEL OMAR GOMEZ CASTILLO; BRAULIO DAVID HERNANDEZ PALAGOT.
 * @Topic: Desarrollo Móvil con Android: Kotlin Fundamentals.
 * @Project: Proyecto Guía: ChronoMaster 2021.
 */

package Proyecto

class Menu {
    /*
AUTOR: EQUIPO 22.
DESCRIPCION: En esta función se inicia con la pantalla de loggin del programa, donde se piden los datos de nombre de
usuario y contraseña y se comparan con los datos inicializados en el objeto usuario.
Si el usuario es validado correctamente  se da acceso al menú principal, el cual variará dependiendo de si la lista de
tareas está vacía o tiene algún elemento. En caso de estar vacía el menú sólo mostrará las opciones de acceder a la
sección de agregar tarea o de cerrar la agenda; si la lista contiene algún elemento se mostrarán todas las opciones a
que contiene esta agenda.
 */
    fun bienvenida() {
        //DESCRIPCION: Variables para leer los datos del usuario y para controlar la opción del menú que se ha seleccionado.
        var op = 0
        var inputNombre = ""
        var inputContrasenna = ""

        /*
        DESCRIPCION: El proceso de inicio de sesión se rodea por un ciclo do-while para asegurar que se repita hasta que
        el usuario sea validad correctamente.
         */
        do {
            print(
                "---------------------------------------------\n" +
                        "Iniciar sesión:\n"
            )
            print("\tIngrese el nombre de usuario: ")
            inputNombre = readLine().toString()
            print("\tIngrese la contraseña: ")
            inputContrasenna = readLine().toString()
        } while (!usuario.loggin(inputNombre, inputContrasenna))    //DESCRIPCION: Condición para el ciclo do-while.

        //DESCRIPCION: Una vez validado el usuario se le da la bienvenida a la agenda.
        println("\nBienvenido a tu agenda, ${usuario.nombre}.")

        /*
        DESCRIPCION: El menú principal se rodea de un ciclo do-while para asegurar que ésta sólo se cierre si se selecciona
        la opción correspondiente al cierre de la agenda.
         */
        do {
            print(
                "---------------------------------------------\n" +
                        "Menú principal:\n"
            )
            //DESCRIPCION: Condición para revisar si la lista de tareas se encuentra vacía o no.
            if (tareas.isEmpty()) {
                println(
                    "\t1) Agregar tarea.\n" +
                            "\t2) Cerrar Agenda."
                )
            } else {
                println(
                    "\t1) Visualizar programa.\n" +
                            "\t2) Revisar conflictos.\n" +
                            "\t3) Ver resumen del usuario.\n" +
                            "\t4) Agregar tarea.\n" +
                            "\t5) Editar tarea.\n" +
                            "\t6) Eliminar tarea.\n" +
                            "\t7) Cerrar Agenda."
                )
            }

            //DESCRIPCION: Lectura de la opción seleccionada por el usuario.
            print("Seleccione una opcion: ")
            op = readLine()!!.toInt()

            /*
            DESCRIPCION: Condición para revisar qué menú se utilizará en el condicional when que controla el menú
            principal.
             */
            if (tareas.isEmpty()) {
                when (op) {
                    1 -> ListaTareas().agregarTarea()
                    2 -> {
                        op = 7
                        print("Hasta la próxima, ${usuario.nombre}.")
                    }
                }
            } else {
                when (op) {
                    1 -> ListaTareas().visualizarPrograma()
                    2 -> ListaTareas().revisarConflictos()
                    3 -> ListaTareas().resumenUsuario()
                    4 -> ListaTareas().agregarTarea()
                    5 -> ListaTareas().editarTarea()
                    6 -> ListaTareas().eliminarTarea()
                    7 -> print("Hasta la próxima, ${usuario.nombre}.")
                    else -> {
                        println("Opción no valida, inténtelo de nuevo...")
                    }
                }
            }
        } while (op != 7)   //DESCRIPCION: Condición para el ciclo do-while.
    }
}