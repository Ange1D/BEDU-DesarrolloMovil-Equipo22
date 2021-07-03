/**
 * Copyright (c) 2021.
 * @Author: Equipo 22.
 * @members: JOSE BERNAL FONSECA; ANGEL OMAR GOMEZ CASTILLO; BRAULIO DAVID HERNANDEZ PALAGOT.
 * @Topic: Desarrollo Móvil con Android: Kotlin Fundamentals.
 * @Project: Proyecto Guía: ChronoMaster 2021.
 */

package TDA

import TDA.Usuario

class listaTareas {
    val tareas = mutableListOf<Tarea>()
    val usuario: Usuario = Usuario("Usuario de prueba", "contraseña_de_prueba")

    fun getTareas() {
        for ((i, tarea) in tareas.withIndex()) println("\t${i + 1}.- \n" +
                "Título: ${tarea.titulo}\n" +
                "Fecha de inicio: ${tarea.fechaInicio}\n" +
                "Fecha final: ${tarea.fechaFinalizacion}\n" +
                "Objetivo: ${tarea.objetivo}\n" +
                "Descripción: ${tarea.descripcion}\n" +
                "Lapso: ${tarea.lapso}" +
                "Dependencia Interna: ${tarea.dependenciaInterna}\n" +
                "Dependencia Externa: ${tarea.dependenciaExterna}\n" +
                "Frecuencia: ${tarea.frecuencia}\n" +
                "Prioridad: ${tarea.prioridad}\n"
        )
    }

    fun eliminarTarea() {
        //DESCRIPCION: Las tareas totales del usuario se establecen en cero para contarlas al terminar de agregar la tarea.
        usuario.tareasTotales = 0
        //DESCRIPCION: Las tareas realizadas del usuario se establecen en cero para contarlas al terminar de editar la tarea.
        usuario.tareasRealizadas
        println(
            "---------------------------------------------\n" +
                    "Eliminar tarea:\n"
        )
        if (tareas.isEmpty()) {
            println("No hay ninguna tarea")
        } else {
            getTareas()
            print("Escriba el número de la tarea que desea borrar: ")
            val delTarea = readLine()?.toInt()
            tareas.removeAt(delTarea!!.minus(1))
            getTareas()
        }

        //DESCRIPCION: Las tareas totales del usuario se establecen como el tamaño de la lista de tareas.
        usuario.tareasTotales = tareas.size
        //DESCRIPCION: Mediante un for y un if se contabilizan las tareas cuyo estado sea Finalizada(true)
        for (tarea in tareas) {
            if (tarea.estado)
                usuario.tareasRealizadas++
        }
    }
}