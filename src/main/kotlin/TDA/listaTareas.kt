/**
 * Copyright (c) 2021.
 * @Author: Equipo 22.
 * @members: JOSE BERNAL FONSECA; ANGEL OMAR GOMEZ CASTILLO; BRAULIO DAVID HERNANDEZ PALAGOT.
 * @Topic: Desarrollo Móvil con Android: Kotlin Fundamentals.
 * @Project: Proyecto Guía: ChronoMaster 2021.
 */

package TDA

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
val tareas = mutableListOf<Tarea>()
val usuario: Usuario = Usuario("Usuario de prueba", "contraseña_de_prueba")

class listaTareas {

    /*
    AUTOR: JOSE BERNAL FONSECA.
    DESCRIPCION: En esta función se utiliza un for con la función WithIndex() de la lista de tareas para generar un listado
    con el índice y el título de las tareas que contiene la lista.
    */
    fun getTareas() {
        for ((i, tarea) in tareas.withIndex()) println("\t${i + 1}.- \n" +
                "\tTítulo: ${tarea.titulo}\n" +
                "\tFecha de inicio: ${tarea.fechaInicio}\n" +
                "\tFecha final: ${tarea.fechaFinalizacion}\n" +
                "\tObjetivo: ${tarea.objetivo}\n" +
                "\tDescripción: ${tarea.descripcion}\n" +
                "\tLapso: ${tarea.lapso}" +
                "\tDependencia Interna: ${tarea.dependenciaInterna}\n" +
                "\tDependencia Externa: ${tarea.dependenciaExterna}\n" +
                "\tFrecuencia: ${tarea.frecuencia}\n" +
                "\tPrioridad: ${tarea.prioridad}\n"
        )
    }

    /*
    AUTOR: JOSE BERNAL FONSECA.
    DESCRIPCION: En esta función se solicita el indice de una tarea que se desee eliminar de la lista de tareas.
    */

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
            getTareas()
        }
    }

    fun agregarTarea() {
        //DESCRIPCION: Las tareas totales del usuario se establecen en cero para contarlas al terminar de agregar la tarea.
        usuario.tareasTotales = 0
        //DESCRIPCION: Petición de datos de la tarea al usuario.
        println(
            "---------------------------------------------\n" +
                    "Agregar tarea:\n"
        )
        print("\tIngrese el título de la tarea: ");
        val title = readLine().toString()
        print("\tIngrese el mes de inicio [MM]: ");
        val mesInicio = readLine()!!.toInt()
        print("\tIngrese el dia de inicio [DD]: ");
        val diaInicio = readLine()!!.toInt()
        print("\tIngrese la hora de inicio [HH]: ");
        val horarioInicio = readLine()!!.toInt()
        print("\tIngrese el mes de finalización [MM]: ");
        val mesFin = readLine()!!.toInt()
        print("\tIngrese el dia de finalización [DD]: ");
        val diaFin = readLine()!!.toInt()
        print("\tIngrese la hora de finalización [HH]: ");
        val horarioFin = readLine()!!.toInt()
        print("\tObjetivo: ")
        val objetivo = readLine().toString()
        print("\tDescripcion: ")
        val descripcion = readLine().toString()
        print("\tDependencia interna: ")
        val dependenciaInterna = readLine().toString()
        print("\tDependencia externa: ")
        val dependenciaExterna = readLine().toString()
        print("\tFrecuencia: ")
        val frecuencia = readLine().toString()
        print("\tPrioridad [1(Poco urgente) - 10(Muy urgente)]: ")
        val prioridad = readLine()!!.toInt()

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
        usuario.tareasTotales = tareas.size
    }


    /*
AUTOR: ANGEL OMAR GOMEZ CASTILLO.
DESCRIPCION: En esta función se registrarán los datos de una tarea ya existente para editarla en la lista de tareas
pendientes.
 */
    fun editarTarea() {
        //DESCRIPCION: Las tareas totales del usuario se establecen en cero para contarlas al terminar de agregar la tarea.
        usuario.tareasTotales = 0
        //DESCRIPCION: Las tareas realizadas del usuario se establecen en cero para contarlas al terminar de editar la tarea.
        usuario.tareasRealizadas
        println(
            "---------------------------------------------\n" +
                    "Editar tarea:\n"
        )
        //DESCRIPCION: Si la lista de tareas está vacía se nos avisa de ello. De lo contrario se solicitan los datos.
        if (tareas.isEmpty()) {
            println("No hay ninguna tarea.")
        } else {
            //DESCRIPCION: Se muestran las tareas que existen para que el usuario seleccione la que desea editar.
            getTareas()
            //DESCRIPCION: Se le solicita al usuario el número de tarea a editar.
            print("Numero de tarea a editar: ")
            val tareaIndice = readLine()!!.toInt()
            print("\n\tEscribe el nuevo título para la tarea: ")
            val tareaEdit = readLine().toString()
            print("\tIngrese el mes de inicio [MM]: ");
            val mesInicio = readLine()!!.toInt()
            print("\tIngrese el dia de inicio [DD]: ");
            val diaInicio = readLine()!!.toInt()
            print("\tIngrese la hora de inicio [HH]: ");
            val horarioInicio = readLine()!!.toInt()
            print("\tIngrese el mes de finalización [MM]: ");
            val mesFin = readLine()!!.toInt()
            print("\tIngrese el dia de finalización [DD]: ");
            val diaFin = readLine()!!.toInt()
            print("\tIngrese la hora de finalización [HH]: ");
            val horarioFin = readLine()!!.toInt()
            print("\tObjetivo: ")
            val objetivo = readLine().toString()
            print("\tDescripcion: ")
            val descripcion = readLine().toString()
            //DESCRIPCION: En esta ocasión sí se le solicita el estado de la tarea: Pendiente(false) o Finalizada(true)
            print("\tEstado de la tarea [Pendiente/Finalizada]: ")
            val estadoLectura = readLine().toString()
            val estadoBoolean = estadoLectura.equals("Finalizada", true)
            print("\tdependenciaInterna: ")
            val dependenciaInterna = readLine().toString()
            print("\tdependenciaExterna: ")
            val dependenciaExterna = readLine().toString()
            print("frecuencia: ")
            val frecuencia = readLine().toString()
            print("\tPrioridad [1(Poco urgente) - 10(Muy urgente)]: ")
            val prioridad = readLine()!!.toInt()

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
            tareas.set(tareaIndice.minus(1), editTarea)
            println("Tarea editada satisfactoriamente.")
            //DESCRIPCION: Mediante un for y un if se contabilizan las tareas cuyo estado sea Finalizada(true)
            for (tarea in tareas) {
                if (tarea.estado)
                    usuario.tareasRealizadas++
            }
        }
    }

    /*
    AUTOR: BRAULIO DAVID HERNANDEZ PALAGOT.
    DESCRIPCION: En esta función se genera un String que indica el lapso de tiempo que abarcará la tarea. Para ello necesia
    recibir dos argumentos de tipo LocalDateTime: el que indica el inicio y el que indica el fin de la tarea.
     */
    fun calcularLapso(inicio: LocalDateTime, fin: LocalDateTime): String {
        return ("Desde $inicio hasta $fin")
    }

}