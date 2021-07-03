//1 Escribe una función normal que reciba el precio de un producto y un cupón promocional.
fun precioTotal(precio:Double, cupon:String) : Double{
    val iva = 0.16
/* 3 La función de la parte 1 debe evaluar los siguientes casos ddel cupón

a) Al ingresar "NOIVA", el precio va sin IVA

b) Al ingresar "HALFIVA", Se cobra el precio con un impuesto del 8%

c) Al ingresar "MINUS100", Se descuenta 100 pesos al precio final

d) Al ingresar "PROMO2020", habrán varios casos:*/
    
if (cupon!="PROMO2020"){
    return when(cupon){
    "NOIVA"-> precio
    "HALFIVA"->precio+(precio*.08)
    "MINUS100"->precio-100
    //e) Al ingresar un cupón inválido, cobrar el monto con IVA
    else->precio+(precio*iva)
	}
    /*Si el precio es entre 0 y 1000 pesos, se aplica 12% de impuestos
 	Si el precio es entre 1000 y 2000, el impuesto es del 4%
 	Si el valor oscila entre 2000 y 4000, el precio final con impuestos se va a la mitad
 	Si el valor es mayor a 4000, el precio baja dos tercios y va sin impuestos*/
} else{
        return when{
        precio in 0.0..1000.0-> precio+(precio*.12)
        precio in 1000.0..2000.0->precio+(precio*.04)
        precio in 2000.0..4000.0->(precio+precio*iva)/2
        precio > 4000.0->precio-((precio*2)/3)
        else -> precio+(precio*iva)
        }
    }
}

//2 Crear una función de orden superior que va a recibir una función que arroja el total a pagar, esta función debe imprimir el precio con un mensaje.

fun total(precio:Double, cupon:String,operacion:(Double,String)->Double): String{
    return "el precio total es "+operacion(precio,cupon)
}

fun main() {
    val precio=total(1000.0,"",::precioTotal)
    println(precio)
    println(total(2000.0,"NOIVA",::precioTotal))
    println(total(3000.0,"MINUS100",::precioTotal))
    println(total(4000.0,"HALFIVA",::precioTotal))
    println(total(5000.0,"PROMO2020",::precioTotal))
}
