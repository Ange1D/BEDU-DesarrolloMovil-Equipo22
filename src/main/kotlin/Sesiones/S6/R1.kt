fun main() {
    val smartWatch = SmartWatch(5000F,"SmartWatch","123456")

	println("Total a pagar:${smartWatch.getTotalPrice(4)}")
}

abstract class Product(price :Float,name:String,sku:String){
    abstract fun getTotalPrice(quantity: Int): Float
}

class SmartWatch(precio: Float,nombre: String,sku: String) : Product( precio, nombre, sku) {
    override fun getTotalPrice(cantidad: Int): Float {
        return cantidad * price
    }
}
