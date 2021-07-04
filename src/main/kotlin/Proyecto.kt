/*
AUTORES: JOSE BERNAL FONSECA; ANGEL OMAR GOMEZ CASTILLO; BRAULIO DAVID HERNANDEZ PALAGOT.
DESCRIPCION: PROYECTO GUÍA. AGENDA: CHRONOMASTER 2021.
NO. DE EQUIPO: 22.
MODULO: KOTLIN FUNDAMENTALS.
 */



/*
AUTOR: BRAULIO DAVID HERNANDEZ PALAGOT.
DESCRIPCION: Se creó una clase llamada Usuario que servirá para almacenar los datos del usuario y la funcionalidad de
loggin, tanto para los datos de prueba que se estarán utilizando durante este proyecto guía, así como los datos de más
usuarios, pensando en la escalabilidad del proyecto.
 */
class Usuario(var nombre: String, var contrasenna: String, var tareasTotales: Int = 0, var tareasRealizadas: Int = 0) {
    //DESCRIPCION: init que mostrará los datos de inicio de sesión del usuario.
    init {
        println(
            "Datos de inicio de sesión:\n" +
                    "\tUsuario: ${this.nombre}.\n" +
                    "\tContraseña: ${this.contrasenna}."
        )
    }
    //DESCRIPCION: Función para validar el nombre de usuario y contraseña.
    fun loggin(nombre: String, contrasenna: String): Boolean {
        return nombre.equals(this.nombre) && contrasenna.equals(this.contrasenna)
    }
}

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
                        "La tarea ${tareas[i]}, con horario: ${horarioComparando.fechaInicio} - ${horarioComparando.fechaFinalizacion}\n" +
                                "entra en conflicto con la tarea ${tareas[j]}, con horario: ${horarioComparador.fechaInicio} - ${horarioComparador.fechaFinalizacion}.\n" +
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
    if (!setConflictos.isEmpty())
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
        "\tNombre de usuario: ${usuario.nombre}.\n" +
                "\tTareas totales: ${usuario.tareasTotales}.\n" +
                "\tTareas finalizadas: ${usuario.tareasRealizadas}.\n" +
                "\n\tTareas pendientes: ${usuario.tareasTotales - usuario.tareasRealizadas}"
    )
}

/*
AUTOR: BRAULIO DAVID HERNANDEZ PALAGOT.
DESCRIPCION: En esta función se registrarán los datos de una tarea para agregarla a la lista de tareas pendientes.
 */
fun agregarTarea() {
    //DESCRIPCION: Las tareas totales del usuario se establecen en cero para contarlas al terminar de agregar la tarea.
    usuario.tareasTotales = 0
    //DESCRIPCION: Petición de datos de la tarea al usuario.
    println(
        "---------------------------------------------\n" +
                "Agregar tarea:\n"
    )
    print("Ingrese el título de la tarea: ");
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





