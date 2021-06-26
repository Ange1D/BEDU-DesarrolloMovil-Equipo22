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
        println(
                    "\t1) Visualizar programa.\n" +
                    "\t2) Revisar conflictos.\n" +
                    "\t3) Ver resumen del usuario.\n" +
                    "\t4) Agregar tarea.\n" +
                    "\t5) Editar tarea.\n" +
                    "\t6) Eliminar tarea.\n" +
                    "\t7) Cerrar Agenda."
        )
        print("Seleccione una opcion: ")
        op = readLine()!!.toInt()

        when (op) {
            1 -> visualizarPrograma()
            2 -> revisarConflictos()
            3 -> resumenUsuario()
            4 -> agregarTarea()
            5 -> editarTarea()
            6 -> eliminarTarea()
            7 -> print("Hasta la próxima, ${usuario.nombre}.")
            else -> {
                print("Opción no valida.")
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
    for ((i, horarioComparando) in horariosTareas.withIndex()) {
        for ((j, horarioComparador) in horariosTareas.withIndex()) {
            if (i != j) {
                if (horarioComparando.contains(horarioComparador.substring(0, 5)) ||
                    horarioComparando.contains(horarioComparador.substring(8))
                )
                    setConflictos.add(
                        "La tarea ${tareas[i]}, con horario: $horarioComparando\n" +
                                "entra en conflicto con la tarea ${tareas[j]}, con horario: $horarioComparador.\n" +
                                "Es necesario editar alguna de las dos."
                    )
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
    )
    print("Ingrese el título de la tarea: ");
        val title = readLine().toString()
        print("\tIngrese el mes de inicio [MM]: "); 
        val mesInicio = readLine().toInt()
        print("\tIngrese el dia de inicio [DD]: "); 
        val diaInicio = readLine().toInt()
        print("\tIngrese la hora de inicio [HH]: "); 
        val horarioInicio = readLine().toInt()
        print("\tIngrese el mes de finalización [MM]: "); 
        val mesFin = readLine().toInt()
        print("\tIngrese el dia de finalización [DD]: "); 
        val diaFin = readLine().toInt()
        print("\tIngrese la hora de finalización [HH]: "); 
        val horarioFin = readLine().toInt()
        print("Objetivo: ")
        val objetivo = readLine()
        print("Descripcion: ")
        val descripcion = readLine()
        print("Lapso: ")
        val lapso = readLine()
        print("dependenciaInterna: ")
        val dependenciaInterna = readLine()
        print("dependenciaExterna: ")
        val dependenciaExterna = readLine()
        print("frecuencia: ")
        val frecuencia = readLine()
        print("prioridad: 1.-Urgente 2.-")
        val prioridad = readLine().toInt()

        tareas.add(Tarea(title,
                        LocalDateTime.of(2021, mesInicio, diaInicio, horaInicio, 00),
                        LocalDateTime.of(2021, mesFin, diaFin, horarFin, 00),
                        objetivo,descripcion,
                        lapso,false,dependenciaInterna,
                        dependenciaExterna,frecuencia,prioridad)
                  )
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
        val tareaIndice = readLine()
        print("Escribe el nuevo título para la tarea: ")
        val tareaEdit = readLine()
        print("\tIngrese el mes de inicio [MM]: "); 
        val mesInicio = readLine().toInt()
        print("\tIngrese el dia de inicio [DD]: "); 
        val diaInicio = readLine().toInt()
        print("\tIngrese la hora de inicio [HH]: "); 
        val horarioInicio = readLine().toInt()
        print("\tIngrese el mes de finalización [MM]: "); 
        val mesFin = readLine().toInt()
        print("\tIngrese el dia de finalización [DD]: "); 
        val diaFin = readLine().toInt()
        print("\tIngrese la hora de finalización [HH]: "); 
        val horarioFin = readLine().toInt()
        print("Objetivo: ")
        val objetivo = readLine()
        print("Descripcion: ")
        val descripcion = readLine()
        print("Lapso: ")
        val lapso = readLine()
        print("dependenciaInterna: ")
        val dependenciaInterna = readLine()
        print("dependenciaExterna: ")
        val dependenciaExterna = readLine()
        print("frecuencia: ")
        val frecuencia = readLine()
        print("prioridad: 1.-Urgente 2.-")
        val prioridad = readLine().toInt()

        tareas.set(tareaIndice?.toInt()!!.minus(1), 
                  Tarea(tareaEdit,LocalDateTime.of(2021, mesInicio, diaInicio, horaInicio, 00),
                        LocalDateTime.of(2021, mesFin, diaFin, horarFin, 00),
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
