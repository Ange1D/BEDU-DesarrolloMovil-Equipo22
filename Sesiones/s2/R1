/**
 * Angel
 */

//2 Crear otra función para calcular el volumen de un prisma rectangular, utilizar la función de área

fun main(){
    val base = 10f
    val altura =20f
	val h = 30f

val v = volumen(base,altura,h)
println("el volumen es $v")

val p = promedio(6f,8f,9f)
println("el promedio es $p")

//val p1 = promedio(6f)
//println("el promedio es $p1")

//val p2 = promedio(6f,8f)
//println("el promedio es $p2")


val p3 = promedio(cal3=9f)
println("el promedio es $p3")

//6OPCIONAL: Buscar una forma de redondear la calificación
//val p4 = (promedio(6f,8f,9f)).roundToInt()
val p4 = (promedio(6f,8f,9f)).toInt()
println("el promedio es $p4")
}

fun volumen(base: Float, altura:Float, h: Float):Float{
    return (base*altura)*h
}

//4Con el ejemplo anterior, crear una función que entregue el promedio de tres calificaciones. Esta debe recibir dos parámetros con calificaciones por defecto 8, y el tercer parámetro no debe venir predefinido.
fun promedio(cal1: Float = 8f,cal2: Float = 8f,cal3: Float): Float{
    return (cal1 + cal2 + cal3)/3f
}
//5 Utilizar la función promedio, Comentar qué pasa si se ingresa sólo una calificación en la función y después con dos. Finalmente, buscar que la función corra enviando únicamente la tercera calificación con 10f:
//Ingresando una o dos variables no funciona la funcioon ya que el tercer parametro no tiene valor por defecto
