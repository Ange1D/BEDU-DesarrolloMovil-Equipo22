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
DESCRIPCION: Variables globales que serán utilizdas en varias partes del proyecto, por lo que se declaran en esta
sección para poder accederlas desde cualquier función del proyecto.
    tareas: Lista mutable que almacenará las tareas guardadas en la agenda.
    usuario: Objeto de tipo Usuario inicializado con los datos de inicio de sesión que se utilizarán durante este
    proyecto guía.
 */

var usuario: Usuario? = null

class ListaTareas {

    companion object {
        val tareas = mutableListOf<Tarea>()
    }

    /*
    AUTOR: JOSE BERNAL FONSECA.
    DESCRIPCION: En esta función se utiliza un for con la función WithIndex() de la lista de tareas para generar un listado
    con el índice y el título de las tareas que contiene la lista.
    */
    private fun imprimirTareas() {
        for ((i, tarea) in tareas.withIndex()) println("\t${i + 1}) \n" +
                "\tTítulo: ${tarea.titulo}\n" +
                "\tFecha de inicio: ${tarea.fechaInicio}\n" +
                "\tFecha final: ${tarea.fechaFinalizacion}\n" +
                "\tObjetivo: ${tarea.objetivo}\n" +
                "\tDescripción: ${tarea.descripcion}\n" +
                "\tLapso: ${tarea.lapso}\n" +
                "\tDependencia Interna: ${tarea.dependenciaInterna}\n" +
                "\tDependencia Externa: ${tarea.dependenciaExterna}\n" +
                "\tFrecuencia: ${tarea.frecuencia}\n" +
                "\tPrioridad: ${tarea.prioridad}\n" +
                "\tEstado: ${if (tarea.estado) "Finalizada" else "Pendiente"}"
        )
    }

    /*
    AUTOR: JOSE BERNAL FONSECA.
    DESCRIPCION: En esta función se solicita el indice de una tarea que se desee eliminar de la lista de tareas.
    */

    fun eliminarTarea() {
        //DESCRIPCION: Las tareas totales del usuario se establecen en cero para contarlas al terminar de agregar la tarea.
        usuario!!.tareasTotales = 0
        //DESCRIPCION: Las tareas realizadas del usuario se establecen en cero para contarlas al terminar de editar la tarea.
        usuario!!.tareasRealizadas
        println(
            "---------------------------------------------\n" +
                    "Eliminar tarea:\n"
        )
        if (tareas.isEmpty()) {
            println("No hay ninguna tarea")
        } else {
            imprimirTareas()
            val delTarea = Validaciones().enRango("Escriba el número de la tarea que desea borrar: ", 0, tareas.size)
            tareas.removeAt(delTarea.minus(1))
            imprimirTareas()
        }

        //DESCRIPCION: Las tareas totales del usuario se establecen como el tamaño de la lista de tareas.
        usuario!!.tareasTotales = tareas.size
        //DESCRIPCION: Mediante un for y un if se contabilizan las tareas cuyo estado sea Finalizada(true)
        for (tarea in tareas) {
            if (tarea.estado)
                usuario!!.tareasRealizadas++
        }
    }


    /*
    AUTOR: JOSE BERNAL FONSECA.
    DESCRIPCION: En esta función si la lista de tareas se encuantra vacía nos mostrará un mensaje que nos lo indicará, de lo
    contrario se ejecutará la función mostrarTareas().
    */
    fun visualizarPrograma() {
        println(
            "---------------------------------------------\n" +
                    "Programa del día:\n"
        )
        if (tareas.isEmpty()) {
            println("No hay ninguna tarea.")
        } else {
            imprimirTareas()
        }
    }

    /*
    AUTOR: BRAULIO DAVID HERNANDEZ PALAGOT.
    DESCRIPCION: En esta función se registrarán los datos de una tarea para agregarla a la lista de tareas pendientes.
    */

    fun agregarTarea() {
        //DESCRIPCION: Las tareas totales del usuario se establecen en cero para contarlas al terminar de agregar la tarea.
        usuario!!.tareasTotales = 0
        //DESCRIPCION: Petición de datos de la tarea al usuario.
        println(
            "---------------------------------------------\n" +
                    "Agregar tarea:\n"
        )

        val title = Validaciones().texto("Ingrese el título de la tarea: ")
        val mesInicio = Validaciones().enRango("Ingrese el mes de inicio [MM]: ", 1, 12)
        val diaInicio = Validaciones().enRango("Ingrese el dia de inicio [DD]: ", 1, 31)
        val horarioInicio = Validaciones().enRango("Ingrese la hora de inicio [HH]: ", 1, 24)
        val mesFin = Validaciones().enRango("Ingrese el mes de finalización [MM]: ", 1, 12)
        val diaFin = Validaciones().enRango("Ingrese el dia de finalización [DD]: ", 1, 31)
        val horarioFin = Validaciones().enRango("Ingrese la hora de finalización [HH]: ", 1, 24)
        val objetivo = Validaciones().texto("Objetivo: ")
        val descripcion = Validaciones().texto("Descripcion: ")
        val dependenciaInterna = Validaciones().texto("Requisitos para considerar la tarea \"Finalizada\": ")
        val dependenciaExterna = Validaciones().texto("Si es necesario completar otra tarea antes de iniciar ésta, indique su nombre: ")
        val frecuencia = Validaciones().texto("Frecuencia: ")
        val prioridad = Validaciones().enRango("Prioridad [1(Poco urgente) - 10(Muy urgente)]: ", 1, 10)

        /*
        DESCRIPCION: Los datos registrados antes son guardados en un objeto de tipo Tarea. El lapso se calcula de forma
        automática para que el usuario no necesite ingresar información redundante; además el estado de la tarea se
        establece automáticamente como Pendiente con un booleano false.
         */
        val newTarea = Tarea(
            title,
            LocalDateTime.of(2021, mesInicio, diaInicio, horarioInicio, 0, 0),
            LocalDateTime.of(2021, mesFin, diaFin, horarioFin, 0, 0),
            objetivo, descripcion,
            calcularLapso(
                LocalDateTime.of(2021, mesInicio, diaInicio, horarioInicio, 0, 0),
                LocalDateTime.of(2021, mesFin, diaFin, horarioFin, 0, 0)
            ),
            false, dependenciaInterna,
            dependenciaExterna, frecuencia, prioridad
        )
        //DESCRIPCION: La tarea creada anteriormente se agrega al final de la lista de tareas.
        tareas.add(newTarea)
        //DESCRIPCION: Las tareas totales del usuario se establecen como el tamaño de la lista de tareas.
        usuario!!.tareasTotales = tareas.size
    }


    /*
    AUTOR: ANGEL OMAR GOMEZ CASTILLO.
    DESCRIPCION: En esta función se registrarán los datos de una tarea ya existente para editarla en la lista de tareas
    pendientes.
    */
    fun editarTarea() {
        //DESCRIPCION: Las tareas totales del usuario se establecen en cero para contarlas al terminar de agregar la tarea.
        usuario!!.tareasTotales = 0
        //DESCRIPCION: Las tareas realizadas del usuario se establecen en cero para contarlas al terminar de editar la tarea.
        usuario!!.tareasRealizadas = 0
        println(
            "---------------------------------------------\n" +
                    "Editar tarea:\n"
        )
        //DESCRIPCION: Si la lista de tareas está vacía se nos avisa de ello. De lo contrario se solicitan los datos.
        if (tareas.isEmpty()) {
            println("No hay ninguna tarea.")
        } else {
            //DESCRIPCION: Se muestran las tareas que existen para que el usuario seleccione la que desea editar.
            imprimirTareas()
            //DESCRIPCION: Se le solicita al usuario el número de tarea a editar.
            val tareaIndice = Validaciones().enRango("Numero de tarea a editar: ", 0, tareas.size)
            val tareaEdit = Validaciones().texto("Escribe el nuevo título para la tarea: ")
            val mesInicio = Validaciones().enRango("Ingrese el mes de inicio [MM]: ", 1, 12)
            val diaInicio = Validaciones().enRango("Ingrese el dia de inicio [DD]: ", 1, 31)
            val horarioInicio = Validaciones().enRango("Ingrese la hora de inicio [HH]: ", 0, 24)
            val mesFin = Validaciones().enRango("Ingrese el mes de finalización [MM]: ", 1, 12)
            val diaFin = Validaciones().enRango("Ingrese el dia de finalización [DD]: ", 1, 31)
            val horarioFin = Validaciones().enRango("Ingrese la hora de finalización [HH]: ", 0, 24)
            val objetivo = Validaciones().texto("Objetivo: ")
            val descripcion = Validaciones().texto("Descripcion: ")
            //DESCRIPCION: En esta ocasión sí se le solicita el estado de la tarea: Pendiente(false) o Finalizada(true)
            val estadoLectura = Validaciones().enRangoTexto("Estado de la tarea [Pendiente/Finalizada]: ", "Pendiente", "Finalizada")
            val estadoBoolean = estadoLectura.equals("Finalizada", true)
            val dependenciaInterna = Validaciones().texto("Requisitos para considerar la tarea \"Finalizada\": ")
            val dependenciaExterna = Validaciones().texto("Si es necesario completar otra tarea antes de iniciar ésta, indique su nombre: ")
            val frecuencia = Validaciones().texto("frecuencia: ")
            val prioridad = Validaciones().entero("Prioridad [1(Poco urgente) - 10(Muy urgente)]: ")

            /*
            DESCRIPCION: Los datos registrados antes son guardados en un objeto de tipo Tarea. El lapso se calcula de forma
            automática para que el usuario no necesite ingresar información redundante; además el estado de la tarea se
            establece según lo que el usuario haya introducido.
             */
            val editTarea = Tarea(
                tareaEdit,
                LocalDateTime.of(2021, mesInicio, diaInicio, horarioInicio, 0, 0),
                LocalDateTime.of(2021, mesFin, diaFin, horarioFin, 0, 0),
                objetivo, descripcion,
                calcularLapso(
                    LocalDateTime.of(2021, mesInicio, diaInicio, horarioInicio, 0, 0),
                    LocalDateTime.of(2021, mesFin, diaFin, horarioFin, 0, 0)
                ),
                estadoBoolean, dependenciaInterna,
                dependenciaExterna, frecuencia, prioridad
            )
            //DESCRIPCION: La tarea creada anteriormente se guarda en el índice de la tarea que se está ediando.
            tareas[tareaIndice.minus(1)] = editTarea
            println("Tarea editada satisfactoriamente.")
            //DESCRIPCION: Mediante un for y un if se contabilizan las tareas cuyo estado sea Finalizada(true)
            for (tarea in tareas) {
                if (tarea.estado)
                    usuario!!.tareasRealizadas++
            }
            //DESCRIPCION: Las tareas totales se vuelven a establecer como el tamaño de la lista de tareas.
            usuario!!.tareasTotales = tareas.size
        }
    }

    /*
    AUTOR: BRAULIO DAVID HERNANDEZ PALAGOT.
    DESCRIPCION: En esta función se genera un String que indica el lapso de tiempo que abarcará la tarea. Para ello necesia
    recibir dos argumentos de tipo LocalDateTime: el que indica el inicio y el que indica el fin de la tarea.
     */

    val calcularLapso: (LocalDateTime,LocalDateTime) -> String = {inicio,fin -> "Desde $inicio hasta $fin"}



    /*
    AUTOR: BRAULIO DAVID HERNANDEZ PALAGOT.
    DESCRIPCION: En esta función se revisará si los horarios de alguna tarea entran en conflicto con los de otra.
    */
    fun revisarConflictos() {
    //DESCRIPCION: Set mutable que almacenará los mensajes de conflicto.
    val setConflictos = mutableSetOf<String>()
    println(
        "---------------------------------------------\n" +
                "Revisión de conflictos:\n"
    )

    /*
    DESCRIPCION: Se utiliza un primer ciclo for para asegurarnos de revisar cada tarea. Se optó por un for que utiliza
    la función WithIndex() de la lista.
     */
    for ((i, horarioComparando) in tareas.withIndex()) {
        /*
        DESCRIPCION: Se utiliza un segundo ciclo for para asegurarnos de comparar la tarea del ciclo anterios con cada
        tarea de la lista. Se optó por un for que utiliza la función WithIndex() de la lista.
         */
        for ((j, horarioComparador) in tareas.withIndex()) {
            /*
            DESCRIPCION: Se utiliza un condicional para evitar que una tarea se compare consigo misma, pues esto
            generaría un falso conflicto.
             */
            if (i != j) {
                /*
                DESCRIPCION: Se comparan ahora los horarios de inicio y fin de cada una de las tareas, si el horario de
                la tarea que se estácomparando contiene el horario de la otra se agrega el mensaje de conflicto al set
                de conflictos declarado anteriormente.
                 */
                if (horarioComparando.fechaInicio.toString().contains(horarioComparador.fechaInicio.toString()) ||
                    horarioComparando.fechaFinalizacion.toString()
                        .contains(horarioComparador.fechaFinalizacion.toString())
                ) {
                    setConflictos.add(
                        "La tarea ${tareas[i].titulo}, con horario: ${horarioComparando.fechaInicio} - ${horarioComparando.fechaFinalizacion}\n" +
                                "entra en conflicto con la tarea ${tareas[j].titulo}, con horario: ${horarioComparador.fechaInicio} - ${horarioComparador.fechaFinalizacion}.\n" +
                                "Es necesario editar alguna de las dos."
                    )
                }
            }
        }
    }

    /*
    DESCRIPCION: Si el set de conflictos no se encuentra vacío nos enlistará cada uno de los conflictos encontrados, de
    lo contrario nos mostrará un mensaje avisándonos que no se encontró ningún conflicto.
     */
    if (setConflictos.isNotEmpty())
        for ((i, elemento) in setConflictos.withIndex())
            println("  ${i + 1}) $elemento\n")
    else
        println("No se encontraron conflictos")
    }

    /*
    AUTOR: BRAULIO DAVID HERNANDEZ PALAGOT.
    DESCRIPCION: En esta función se mostrarán los datos del usuario, con el objetivo de que pueda revisar cuántas tareas
    tiene aún pendientes.
    */
    fun resumenUsuario() {
    println(
        "---------------------------------------------\n" +
                "Resumen del usuario:\n"
    )
    println(
        "\tNombre de usuario: ${usuario!!.nombre}.\n" +
                "\tTareas totales: ${usuario!!.tareasTotales}.\n" +
                "\tTareas finalizadas: ${usuario!!.tareasRealizadas}.\n" +
                "\n\tTareas pendientes: ${usuario!!.tareasTotales - usuario!!.tareasRealizadas}"
    )
    }


}