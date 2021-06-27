import java.time.LocalDateTime

//ANGEL
data class Tarea(var titulo: String, var fechaInicio: LocalDateTime, var fechaFinalizacion: LocalDateTime, var objetivo: String = "", var descripcion: String = "", var lapso: String = "",
                 var estado: Boolean = false, var dependenciaInterna: String = "", var dependenciaExterna: String = "", var frecuencia: String = "", var prioridad: Int = 0)

val tareas = mutableListOf<Tarea>()


fun main() {
    bienvenida()
}

//BRAULIO
class Usuario(var nombre: String, var contrasenna: String, var tareasTotales: Int = 0, var tareasRealizadas: Int = 0) {
    init {
        println(
            "Datos de inicio de sesión:\n" +
                    "\tUsuario: ${this.nombre}.\n" +
                    "\tContraseña: ${this.contrasenna}."
        )
    }

    fun loggin(nombre: String, contrasenna: String): Boolean {
        return nombre.equals(this.nombre) && contrasenna.equals(this.contrasenna)
    }
}

fun bienvenida() {
    var op = 0
    var inputNombre = ""
    var inputContrasenna = ""
    val usuario = Usuario("Usuario de prueba", "contraseña_de_prueba")

    do {
        print(
            "---------------------------------------------\n" +
                    "Iniciar sesión:\n"
        )
        print("\tIngrese el nombre de usuario: ")
        inputNombre = readLine().toString()
        print("\tIngrese la contraseña: ")
        inputContrasenna = readLine().toString()
    } while (!usuario.loggin(inputNombre, inputContrasenna))


    println("\nBienvenido a tu agenda, ${usuario.nombre}.")

    do {
        print(
            "---------------------------------------------\n" +
                    "Menú principal:\n"
        )
        //Se agregó la condición en caso de que la agenda esté vacía
        if (tareas.isEmpty()) {
            println(
                "\t1) Agregar tarea.\n" +
                "\t2) Cerrar Agenda."
            )
        }
        else {
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
        print("Seleccione una opcion: ")
        op = readLine()!!.toInt()
        //Se agregó esta validación para ir acorde a la anterior
        if (tareas.isEmpty()) {
            when (op) {
                1 -> agregarTarea()
                2 -> { op = 7
                    print("Hasta la próxima, ${usuario.nombre}.") }
            }
        }
        else {
            when (op) {
                1 -> visualizarPrograma()
                2 -> revisarConflictos()
                3 -> resumenUsuario()
                4 -> agregarTarea()
                5 -> editarTarea()
                6 -> eliminarTarea()
                7 -> print("Hasta la próxima, ${usuario.nombre}.")
                else -> {
                    println("Opción no valida, inténtelo de nuevo...")
                }
            }
        }
    } while (op != 7)
}

//JOSE
fun visualizarPrograma() {
    println(
        "---------------------------------------------\n" +
                "Programa del día:\n"
    )
    if (tareas.isEmpty()) {
        println("No hay ninguna tarea.")
    } else {
        mostrarTareas()
    }
}

//BRAULIO
fun revisarConflictos() {
    val setConflictos = mutableSetOf<String>()
    println(
        "---------------------------------------------\n" +
                "Revisión de conflictos:\n"
    )
    
    for ((i, horarioComparando) in tareas.withIndex()) {
        for ((j, horarioComparador) in tareas.withIndex()) {
            if (i != j) {
                if (horarioComparando.fechaInicio.toString().contains(horarioComparador.fechaInicio.toString()) ||
                    horarioComparando.fechaFinalizacion.toString().contains(horarioComparador.fechaFinalizacion.toString())) {
                    setConflictos.add(
                        "La tarea ${tareas[i]}, con horario: ${horarioComparando.fechaInicio} - ${horarioComparando.fechaFinalizacion}\n" +
                                "entra en conflicto con la tarea ${tareas[j]}, con horario: ${horarioComparador.fechaInicio} - ${horarioComparador.fechaFinalizacion}.\n" +
                                "Es necesario editar alguna de las dos."
                    )
                }
            }
        }
    }
    
    if (!setConflictos.isEmpty())
        for ((i, elemento) in setConflictos.withIndex())
            println("  ${i + 1}) $elemento\n")
    else
        println("No se encontraron conflictos")
}

//MANUEL
fun resumenUsuario() {
    println(
        "---------------------------------------------\n" +
                "Resumen del usuario:\n"
    )
}

//BRAULIO
fun agregarTarea() {
    println(
        "---------------------------------------------\n" +
                "Agregar tarea:\n"
      //José: Se hicieron ligeras correcciones, ahora ya guarda la tarea (falta imprimir la salida correctamente)
    )
    print("Ingrese el título de la tarea: ");
    val title = readLine().toString()
    print("\tIngrese el mes de inicio [MM]: ");
    val mesInicio = readLine()!!.toInt()
    print("\tIngrese el dia de inicio [DD]: ");
    val diaInicio = readLine()!!.toInt()
    print("\tIngrese la hora de inicio [HH]: ");
    val horaInicio = readLine()!!.toInt()
    print("\tIngrese el mes de finalización [MM]: ");
    val mesFin = readLine()!!.toInt()
    print("\tIngrese el dia de finalización [DD]: ");
    val diaFin = readLine()!!.toInt()
    print("\tIngrese la hora de finalización [HH]: ");
    val horarioFin = readLine()!!.toInt()
    print("Objetivo: ")
    val objetivo = readLine().toString()
    print("Descripcion: ")
    val descripcion = readLine().toString()
    print("Lapso: ")
    val lapso = readLine().toString()
    print("dependenciaInterna: ")
    val dependenciaInterna = readLine()!!.toBoolean()
    print("dependenciaExterna: ")
    val dependenciaExterna = readLine().toString()
    print("frecuencia: ")
    val frecuencia = readLine().toString()
    print("prioridad: 1.-Urgente 2.-")
    val prioridad = readLine().toString()

    val newTarea: Tarea = Tarea(title, LocalDateTime.of(2021, mesInicio, diaInicio, horaInicio, 0,0),
        LocalDateTime.of(2021, mesFin, diaFin, horarioFin, 0, 0), objetivo,  descripcion, lapso,
        dependenciaInterna, dependenciaExterna, frecuencia, prioridad)
    tareas.add(newTarea)
}

//ANGEL
fun editarTarea() {
    println(
        "---------------------------------------------\n" +
                "Editar tarea:\n"
    )
    if (tareas.isEmpty()) {
        println("No hay ninguna tarea.")
    } else {
        mostrarTareas()
        print("Numero de tarea a editar: ")
        val tareaIndice = readLine()?.toInt()!!
        print("Escribe el nuevo título para la tarea: ")
        val tareaEdit = readLine().toString()
        print("\tIngrese el mes de inicio [MM]: ");
        val mesInicio = readLine()?.toInt()!!
        print("\tIngrese el dia de inicio [DD]: ");
        val diaInicio = readLine()?.toInt()!!
        print("\tIngrese la hora de inicio [HH]: ");
        val horarioInicio = readLine()?.toInt()!!
        print("\tIngrese el mes de finalización [MM]: ");
        val mesFin = readLine()?.toInt()!!
        print("\tIngrese el dia de finalización [DD]: ");
        val diaFin = readLine()?.toInt()!!
        print("\tIngrese la hora de finalización [HH]: ");
        val horarioFin = readLine()?.toInt()!!
        print("Objetivo: ")
        val objetivo = readLine().toString()
        print("Descripcion: ")
        val descripcion = readLine().toString()
        print("Lapso: ")
        val lapso = readLine().toString()
        print("dependenciaInterna: ")
        val dependenciaInterna = readLine().toString()
        print("dependenciaExterna: ")
        val dependenciaExterna = readLine().toString()
        print("frecuencia: ")
        val frecuencia = readLine().toString()
        print("prioridad: 1.-Urgente 2.-")
        val prioridad = readLine()?.toInt()!!

        tareas.set(tareaIndice.minus(1),
            Tarea(tareaEdit,
                LocalDateTime.of(2021, mesInicio, diaInicio, horarioInicio, 0,0),
                LocalDateTime.of(2021, mesFin, diaFin, horarioFin, 0,0),
                objetivo,descripcion,
                lapso,false,dependenciaInterna,
                dependenciaExterna,frecuencia,prioridad)
        )

        println("Tarea editada satisfactoriamente.")
    }
}

//JOSE
fun eliminarTarea() {
    println(
        "---------------------------------------------\n" +
                "Eliminar tarea:\n"
    )
    if (tareas.isEmpty()) {
        println("No hay ninguna tarea")
    } else {
        mostrarTareas()
        print("Escriba el número de la tarea que desea borrar: ")
        val delTarea = readLine()?.toInt()
        tareas.removeAt(delTarea!!.minus(1))
        mostrarTareas()
    }
}

//Nueva función para imprimir el arreglo completo de tareas
fun mostrarTareas() {
    for ((i, tarea) in tareas.withIndex()) println("\t${i + 1}.- $tarea")
}
