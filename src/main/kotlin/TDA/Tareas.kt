/**
 * Copyright (c) 2021.
 * @Author: Equipo 22.
 * @members: JOSE BERNAL FONSECA; ANGEL OMAR GOMEZ CASTILLO; BRAULIO DAVID HERNANDEZ PALAGOT.
 * @Topic: Desarrollo Móvil con Android: Kotlin Fundamentals.
 * @Project: Proyecto Guía: ChronoMaster 2021.
 */

package TDA

import java.time.LocalDateTime

class Tareas (
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
) {
}