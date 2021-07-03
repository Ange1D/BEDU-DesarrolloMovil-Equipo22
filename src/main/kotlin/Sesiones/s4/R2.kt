fun main() {

    /*val viajeMonterrey = National("Monterrey")
    viajeMonterrey.quotePrice(2)
    viajeMonterrey.reserve(4)

    println("--------------")

    val viajeBajaMonterrey = NationalLowSeason("Monterrey")
    viajeBajaMonterrey.reserve(4)
    */
    val viajeSCDLC = NationalLowSeason("San Cristóbal de las casas")
    viajeSCDLC.cancelTravel()
    viajeSCDLC.reserve(2)
    viajeSCDLC.cancelTravel()

}

abstract class Travel {

    abstract val country: String
    abstract val city: String

    protected val serviceType = "Viaje"
    protected var reserved = false
    protected var paidAmount = 0

    fun reserve(numDays: Int){
        if(reserved){
            println("""¡Ya reservaste tu viaje! 
                       País: $country
                       Ciudad: $city
                       Precio: $paidAmount""".trimMargin())
            return
        }
        val amount = getPrice(numDays)
        if(amount==0){
            return
        }
        reserved = true
        paidAmount = amount
        println("""¡Viaje reservado exitosamente! 
                       País: $country
                       Ciudad: $city
                       Precio: $paidAmount""".trimMargin())
    }
//2 Existe un miembro en la clase Travel que a pesar de ser abstracta, podría ser idéntica tanto en National como en International, ¿Cuál es? descúbrela, agrega el cuerpo en la clase abstracta y elimínala de sus hijos.
    fun quotePrice(numDays: Int) {
    val price = getPrice(numDays)
    if(price==0){ //si no existe tarifa para esa ciudad, notificamos al usuario
        println("Lo sentimos, no hacemos viajes a esta ciudad")
    } else{
        println("Tu viaje a $city cuesta \$$price") //notificamos el precio al usuario
    }
	}

    //es protected para que sólo se pueda obtener el valor numérico desde la clase
    protected abstract fun getPrice(numDays: Int): Int

}

open class National(override val city:String): Travel(){
    override val country = "Mexico"

    //este map es sun catálogo los diferentes precios por día dependiendo de la ciudad
    protected val fees = mapOf(
        "Monterrey" to 400,
        "Guadalajara" to 350,
        "CDMX" to 360,
        "San Cristóbal de las casas" to 240,
        "San Miguel de Allende" to 320
    )

    override fun getPrice(numDays: Int): Int {
        val fee = fees[city] //obtenemos la tarifa según la ciudad
        return if (fee==null) 0 else fee*numDays //regresamos 0 si no hay tarifa, si sí, hacemos el cálculo
    }
}

interface IPromotion {
    val discount: Int //el descuento en porcentaje o en cantidad
    val typeDiscount: Int //porcentaje o cantidad

    fun getDiscountPrice(amount:Int): Int{ //obtener el precio real ya con el descuento
        return if(typeDiscount == 0) { //0 es porcentaje
            (amount * (100-discount))/100
        } else{ //cantidad específica
            amount - discount
        }
    }
}


class NationalLowSeason(city: String) : National(city),IPromotion,Cancellable {
    override  val discount = 10 //es porcentaje, o sea 10%
    override val typeDiscount = 0 //0 para porcentaje, 1 para cantidad

    override fun getPrice(numDays: Int): Int {
        val amount = super.getPrice(numDays)
        return if (amount == 0) 0 else getDiscountPrice(amount)
    }
//4 crear una interfaz que permita cancelar viajes. Implementarlo en la clase NationalLowSeason. Hacer pruebas.
    override fun cancelTravel() {
        if(reserved){
            reserved = false
            paidAmount=0
            println("Viaje cancelado ")
        } else{
            println("Viaje no reservado")
        }
    }
}


//1 Crear la clase International para viajes internacionales, contemplar que ahora el usuario proporciona el nombre del País y la Ciudadd
class International(override val country: String, override val city: String) : Travel() {
    /*3 Debemos establecer los impuestos por país, y las ciudades a donde viajar:

    Alemania tiene el 16% del precio total como impuesto y las ciudades disponibles son:
        Munich, $980 por día
        Berlín, $820 por día
        Francfort, $850 por día

    Chile cobra únicamente el 5% como impuesto y sus ciudades son:
        Santiago, $643 por día
        Valparaíso, $721 por día

    Canadá cobra el 10% de impuesto y las ciudades a visitar son:
        Vancouver, $620 por día
        Ottawa, $680 por día
        Montreal, $600 por día
	*/
    
    private val germanyFees =  mapOf(
    	"Munich" to 980,
    	"Berlín" to 820,
    	"Francfort" to 850
    )

    private val chileFees =  mapOf(
        "Santiago" to 643,
        "Valparaíso" to 721
    )

    private val canadaFees =  mapOf(
        "Vancouver" to 620,
        "Ottawa" to 680,
        "Montreal" to 600
    )

    val taxGermany = 0.16
    val taxChile = 0.05
    val taxCanada = 0.1
    
//3 Redefinir la función getPrice() para que se obtenga el precio de un viaje con impuesto incluído. Hacer pruebas.
    override fun getPrice(numDays: Int): Int {
    when(country){
        "Alemania" ->{
            val fee = germanyFees[city]
            if(fee==null){
                return 0
            }
            return (fee * numDays * (1 + taxGermany) ).toInt()

        }
        "Chile" ->{
            val fee = chileFees[city]
            if(fee==null){
                return 0
            }
            return (fee * numDays * (1 + taxChile)).toInt()
        }
        "Canada" ->{
            val fee = canadaFees[city]
            if(fee==null){
                return 0
            }
            return (fee * numDays * (1 + taxCanada) ).toInt()
        }
        else ->{
            return 0
        }
    }
}
}

//4 crear una interfaz que permita cancelar viajes. Implementarlo en la clase NationalLowSeason. Hacer pruebas.
interface Cancellable {

    fun cancelTravel()

}
