/**
 * Copyright (c) 2021.
 * @Author: Equipo 22.
 * @members: JOSE BERNAL FONSECA; ANGEL OMAR GOMEZ CASTILLO; BRAULIO DAVID HERNANDEZ PALAGOT.
 * @Topic: Desarrollo Móvil con Android: Kotlin Fundamentals.
 * @Project: Proyecto Guía: ChronoMaster 2021.
 */

package proyecto

/*
AUTOR: BRAULIO DAVID HERNANDEZ PALAGOT.
DESCRIPCION: Se creó una clase llamada Usuario que servirá para almacenar los datos del usuario y la funcionalidad de
loggin, tanto para los datos de prueba que se estarán utilizando durante este proyecto guía, así como los datos de más
usuarios, pensando en la escalabilidad del proyecto.
*/

data class Usuario(var nombre: String, var contrasenna: String, var tareasTotales: Int = 0, var tareasRealizadas: Int = 0)
