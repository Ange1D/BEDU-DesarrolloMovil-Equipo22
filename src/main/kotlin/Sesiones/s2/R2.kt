/**Angel*/
//Crear una función que pida como parámetros las medidas de los lados de un triángulo. Debe imprimirnos el tipo de tríangulo:

    //Equilatero: los tres lados tienen el mismo valor
    //Isóceles: Tiene dos lados iguales
    //Escaleno: Los tres lados son diferentes
fun main(){
println(triangulo(1,1,1))
println(triangulo(1,2,1))
println(triangulo(1,2,3))
println(tipoDato(5))
}

fun triangulo(l1: Int, l2: Int, l3: Int){
    
    
    when{
        l1==l2 && l2==l3 ->  println("Equilátero")
        l1==l2 || l2==l3 || l1==l3->  println("Isóceles")
        l1!=l2 && l2!=l3->  println("Escaleno")
    }

    
}
//2Con When identificar si el tipo de dato es:
    //String
    //Int
    //Double
    //Otro

fun tipoDato(dato:Any){
     when (dato) {
        is String -> print("Es String")
        is Int -> print("Es Int")
        is Double -> print("Double")
        else -> {
            print("Es otro tipo de dato")
        }
    }

}
