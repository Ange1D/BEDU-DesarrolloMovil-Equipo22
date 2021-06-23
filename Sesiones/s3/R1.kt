fun main() {
    //2 crear un objeto de Vehículo y setear los datos de tu coche:
    val myCar = car()

	myCar.color="Gris"
	myCar.marca="Tesla"
	myCar.modelo="Model 3"
	myCar.placas="INZ54A48"
    
    //3 Checar si el coche está encendido (imprimiendo el status del coche), encender el cocche y volver a checar
    var encendido = if(myCar.encendido == true) "encendido" else "apagado"
    println("El Vehículo esta $encendido")
	myCar.turnOn()
	println("El Vehículo está $encendido")
    
    //4 Verificar en nivel del tanque imprimendo la cantidad de gasolina, recargar unos cuantos litros y después volver a consultar
    println("El tanque tiene ${myCar.gasolina}")
	myCar.refill(10)
	println("El Vehículo tiene ${myCar.gasolina} litros de gasolina")

	}

//1 Crear una clase que represente un vehículo, que tenga las siguientes propiedades:
//Color Marca Modelo placas encendido (prendido o apagado) Gasolina Encender Apagar Recargar


class car {
    var color= ""
    var marca = ""
    var modelo = ""
    var placas = ""
    var gasolina = 0
    var encendido = false


    fun turnOn(){
        encendido=true
    }

    fun turnOff(){
        encendido=false
    }

    fun refill(litros:Int){
        gasolina+=litros
    }
}	
