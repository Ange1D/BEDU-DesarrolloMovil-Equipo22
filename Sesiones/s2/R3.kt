/**Angel*/
//Crear y utilizar una función que regrese el número de veces que se repite un nombre en la siguiente lista de nombres:
//Pedro Luis, Juan Manuel, Juan Luis, María Inés, Romeo, Ernesto, Juan Pedro, Ariadna, Mireya María, Ana Sofía, José Juan
fun main(){
val nombre = buscarNombre("Juan")
println("El nombre se repite  $nombre  veces")


//adaptar el código del while a esta nueva forma y describir la diferencia entre las dos.
var y = 20
do{y--
   println(y)
   }while (y > 0)

//Do while verifica la condicion al final


}

val listaNombres = listOf("Pedro Luis","Juan Manuel","Juan Luis","María Inés","Romeo", "Ernesto","Juan Pedro", "Ariadna","Mireya María","Ana Sofía","José Juan")

fun buscarNombre(nombre: String): Int{
    var count = 0
    for(Nombre in listaNombres){
        if(nombre in Nombre){
            count++
        }
    }
    return count
}
