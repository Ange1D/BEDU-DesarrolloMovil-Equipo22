fun main() {
   val lista = mutableListOf(10,8, 9 ,5,3,2,5,1,7,6,9,4,10,3,6,2,6,5)
   println(lista)
   //Sacar el promedio de la clase.
   val promedio = lista.average()
   println("el promedio es $promedio")
   //2 Verificar mediante la función none que ningún alumno haya sacado una calificación menor a 4
   println(if(lista.none{it<4}) "Hay calificaciones menores a 4"
   else "No hay calificaciones menores a 4")
   //3 Subir puntos extra a cada calificación, tomando en cuenta que la calificación máxima es de 10. No olvidar el principio de inmutabiliddad.
   val extra = lista.map{if(it>10) it else it + 1}
   println(extra)  
}
