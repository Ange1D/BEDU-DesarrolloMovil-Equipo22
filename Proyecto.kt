val tareas = mutableListOf<String>()
val horariosTareas = mutableListOf<String>() //Lista mutable para guardar los horarios de cada tarea

fun main() {
    bienvenida()
}
//BRAULIO
class usuario(nombre:String, contraseña:String,tareasTotales:Int,tareasRealizadas:Int){
fun login(){}
}
//JOSE
class tareas(titulo:String,objetivo:String,descripcion:String,fechaInicio:Date, fechaFinalizacion:date, lapso:String
            estado:Boolea, dependenciaInterna:String , dependenciaExterna:String,frecuencia:String, prioridad:Int){
constructor agregarTarea(){}
fun editarTarea(){}
}
    

fun bienvenida() {
    var op = 0
    print("Ingrese su nombre: ")
    val inputNombre = readLine()
    println("Bienvenido a tu agenda, $inputNombre.")

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
            4 -> AgregarTarea()
            5 -> editarTarea()
            6 -> eliminarTarea()
            7 -> print("Hasta la próxima $inputNombre.")
            else -> {
                print("opcion no valida.")
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
    for ((i, horarioComparando) in horariosTareas.withIndex()){
        for ((j, horarioComparador) in horariosTareas.withIndex()) {
            if (i != j) {
                if (horarioComparando.contains(horarioComparador.substring(0, 5)) ||
                    horarioComparando.contains(horarioComparador.substring(8)))
                setConflictos.add("La tarea ${tareas[i]}, con horario: $horarioComparando\n" +
                        "entra en conflicto con la tarea ${tareas[j]}, con horario: $horarioComparador.\n" +
                        "Es necesario editar alguna de las dos.")
            }
        }
    }
    if (!setConflictos.isEmpty())
        for ((i, elemento) in setConflictos.withIndex())
            println("  ${i+1}) $elemento\n")
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
fun AgregarTarea() {
    println(
        "---------------------------------------------\n" +
                "Agregar tarea:\n"
    )
    var horario = ""
    print("Ingrese el título de la tarea: ");
    var title = readLine().toString()
    tareas.add(title)
    print("\tIngrese la hora de inicio [HH:mm]: "); horario += readLine().toString()
    horario += " - "
    print("\tIngrese la hora de finalización [HH:mm]: "); horario += readLine().toString()
    horariosTareas.add(horario)
}

//ANGEL
fun editarTarea() {
    var horario = ""
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
        print("\tIngrese la hora de inicio [HH:mm]: "); horario += readLine().toString()
        horario += " - "
        print("\tIngrese la hora de finalización [HH:mm]: "); horario += readLine().toString()

        tareas.set(tareaIndice?.toInt()!!.minus(1), tareaEdit.toString())
        horariosTareas.set(tareaIndice?.toInt()!!.minus(1), horario)
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
