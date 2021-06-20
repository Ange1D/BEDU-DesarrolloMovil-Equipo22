val tareas = mutableListOf<String>() 

fun main() {
  bienvenida()
}

fun bienvenida(){
  print("Ingrese nombre:")
  val inputNombre = readLine()
  
    print("Bienvenido $inputNombre Menu \n1 visualizar programa \n2 revisar conflictos \n3 ver resumen del usuario \n4 Agregar tarea \n5 Editar tarea \n6 Eliminar tarea\n")
    print("Seleccione una opcion:")
    val input = readLine()

    when(input?.toInt()){
      1 -> visualizarPrograma()
      2 -> revisarConflictos()
      3 -> resumenUsuario()
      4 -> AgregarTarea()
      5 -> editarTarea()
      6 -> eliminarTarea()
      else -> {  print("opcion no valida")  } 
    }
}

//JOSE
fun visualizarPrograma(){
  mostrarTareas()
}

//BRAULIO
fun revisarConflictos(){
}

//MANUEL
fun resumenUsuario(){
}

//BRAULIO
fun AgregarTarea(){
}

//ANGEL
fun editarTarea(){
    if(tareas.isEmpty()){
        println("No hay ninguna tarea")
    }else{
      mostrarTareas()
        print("Numero de tarea a editar")
        val tareaIndice = readLine()
        print("Escribe la nueva tarea")
        val tareaEdit = readLine()
        tareas.set(tareaIndice?.toInt()!!.minus(1), tareaEdit.toString())
        println("Tarea editada")
    }
}

//JOSE
fun eliminarTarea(){
  mostrarTareas()
  print("Escriba el número de la tarea que desea borrar: ")
  val delTarea = readLine()?.toInt()
  tareas.removeAt(delTarea!!.minus(1))
  mostrarTareas()
}

//Nueva función para imprimir el arreglo completo de tareas
fun mostrarTareas(){
  for ((i, tarea) in tareas.withIndex()) println("${i + 1}.- $tarea")
}


