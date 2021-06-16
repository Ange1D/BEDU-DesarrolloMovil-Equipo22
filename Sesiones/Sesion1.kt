/**
 * Angel
 */

const val PI = 3.1416 
fun main() {
    //println("Hello")
    //println(" world!!!")
    val decimal = 3.1416
    System.out.println(decimal.javaClass.kotlin.qualifiedName)
    //Volver flotante a la variable decimal
    val flotante = decimal.toFloat()
    println(flotante.javaClass.kotlin.qualifiedName)
    //Declarar una variable const val con el valor de PI y multiplicarla por 2 veces nuestra variable decimal para sacar el perímetro de un círculo
    val c = 2*PI*decimal
    println(c)
    //para el ejemplo anterior, utilizar un String Template para imprimir el texto El perímetro del círculo es: [resultado] siendo resultado nuestra variable perímetro
    println("El perímetro del círculo es: "+c)
    
    //Expresarla ahora con operadores:
    //val pendiente=(y2-y1)/(x2-x1) 
    
    //Resolver el valor de la pendiente, tomanto en cuenta que P1(4,3), P2(-3,-2)
    val x1 = 4
	val y1 = 3
	val x2 = -3
    val y2 = -2.0
	val pendiente=(y2-y1)/(x2-x1) 
	println(pendiente)

//Del ejercicio anterior, responder: ¿Por qué el resultado obtenido difiere del resultado esperado?
//porque los datos los toma como enteros(Int)

//Encontrar una solución para que se refleje el resultado
	println(pendiente)
}
