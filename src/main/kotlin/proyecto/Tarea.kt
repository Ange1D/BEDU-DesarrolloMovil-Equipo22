/**
 * Copyright (c) 2021.
 * @Author: Equipo 22.
 * @members: JOSE BERNAL FONSECA; ANGEL OMAR GOMEZ CASTILLO; BRAULIO DAVID HERNANDEZ PALAGOT.
 * @Topic: Desarrollo Móvil con Android: Kotlin Fundamentals.
 * @Project: Proyecto Guía: ChronoMaster 2021.
 */

package proyecto

/*
DESCRIPCION: Importación de la bibilioteca LocalDateTime que se utilizará para establecer los horarios de cada tarea.
 */
import java.time.LocalDateTime

/*
AUTOR: ANGEL OMAR GOMEZ CASTILLO.
DESCRIPCION: Se creó una data class llamada Tarea que se utilizará para almacenar los datos de cada tarea que el usuario
ingrese en la agenda.
 */
data class Tarea(
    var titulo: String,
    var fechaInicio: LocalDateTime,
    var fechaFinalizacion: LocalDateTime,
    var objetivo: String = "",
    var descripcion: String = "",
    var lapso: String = "",
    var estado: Boolean = false,
    var dependenciaInterna: String = "",
    var dependenciaExterna: String = "",
    var frecuencia: String = "",
    var prioridad: Int = 0
)
