/**
 * Copyright (c) 2021.
 * @Author: Equipo 22.
 * @members: JOSE BERNAL FONSECA; ANGEL OMAR GOMEZ CASTILLO; BRAULIO DAVID HERNANDEZ PALAGOT.
 * @Topic: Desarrollo Móvil con Android: Kotlin Fundamentals.
 * @Project: Proyecto Guía: ChronoMaster 2021.
 */

package proyecto

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

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

    interface Callback {
        fun onSuccess(user: Usuario)
        fun onFailure(exception: Exception)
    }

    private suspend fun fetchUserCoroutine(username: String, password: String): Usuario =
        suspendCancellableCoroutine { cancellableContinuation ->
            fetchUser(object : Callback {
                override fun onSuccess(user: Usuario) {
                    cancellableContinuation.resume(user)
                }

                override fun onFailure(exception: Exception) {
                    cancellableContinuation.resumeWithException(exception)
                }
            }, username, password)
        }

    private fun fetchUser(callback: Callback, username: String, password: String) {
        Thread {
            Thread.sleep(3_000)

            if (username == "BEDU" && password == "BEDU_EQUIPO_22")
                callback.onSuccess(Usuario(username, password))
            else
                callback.onFailure(Exception("Datos de inicio de sesión incorrectos."))
        }.start()
    }

    fun bienvenida() = runBlocking {
        var op: Int
        do{
            print(
                "---------------------------------------------\n" +
                        "Iniciar sesión:\n"
            )
            val inputNombre = Validaciones().texto("\tIngrese el nombre de usuario: ")
            val inputContrasenna = Validaciones().texto("\tInrese la contraseña: ")
            try {
                println("Iniciando recuperación de usuario")
                usuario = fetchUserCoroutine(inputNombre, inputContrasenna)
            } catch (exception: Exception) {
                println("Error: $exception.")
            }
        } while (usuario == null)

        //DESCRIPCION: Si en el try-catch anterior usuario quedó como null, se cierra el programa
        if (usuario != null) {
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
                if (ListaTareas.tareas.isEmpty()) {
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
                op = Validaciones().entero("Selecciones una opción: ")

                /*
                DESCRIPCION: Condición para revisar qué menú se utilizará en el condicional when que controla el menú
                principal.
                 */
                if (ListaTareas.tareas.isEmpty()) {
                    when (op) {
                        1 -> ListaTareas().agregarTarea()
                        2 -> {
                            op = 7
                            print("Hasta la próxima, ${usuario!!.nombre}.")
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
                        7 -> print("Hasta la próxima, ${usuario!!.nombre}.")
                        else -> {
                            println("Opción no valida, inténtelo de nuevo...")
                        }
                    }
                }
            } while (op != 7)   //DESCRIPCION: Condición para el ciclo do-while.
        }
    }
}