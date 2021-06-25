fun main() {
    
    //val enemy = Goomba()

    //enemy.collision("Enemy")
    //enemy.collision("Weapon")

    
    val enemy2 = Koopa()
	//3 Comprobar los ejercicios anteriores haciendo que un Koopa colisione dos veces con un Weapon.
    enemy2.collision("Enemy")
    enemy2.collision("Weapon")
    enemy2.collision("Weapon")
    
    //5 Comprobar el ejercicio anterior haciendo que un Koopa paratroopa colisione tres veces con un Weapon.
    val enemy3 = KoopaParatroopa()
    enemy3.collision("Weapon")
    enemy3.collision("Weapon")
    enemy3.collision("Weapon")
    enemy3.collision("Weapon")

}

open class Enemy(val name: String,val strength:Int) {

    protected var direction: String ="LEFT" //la direccción hacia donde camina un enemigo

    protected fun changeDirection(){ //Cambiar el sentido de movimiento al contrario
        direction = if (direction=="RIGHT") "LEFT" else "RIGHT"
        println("$name va en dirección $direction")
    }

    protected fun die(){ //indicamos al jugador que nuestro enemigo ha muerto
        println("$name ha muerto")
    }

    open fun collision(collider: String){ //decidir qué acción ejecutar dependiendo del objeto con que se ccolisiona
        when(collider){
            "Weapon" -> die()
            "Enemy" -> changeDirection()
        }
    }
}



open class Koopa :
    Enemy("Koopa", 2){

    init {
        println("iniciando subclase de $name")
    }

    protected open var state = "Walking"
        //1 Imprimir el estado de Koopa cada que este cambie (borrar la impresión actual cuando colisiona con un Weapon)
        set(value) {
    	field = value
    	println("El Koopa esta $field")
		}

    override fun collision(collider: String){
        when(collider){
            "Weapon" -> {
                //2 La primera vez que un Koopa colisiona con un Weapon, se vuelve shell: la segunda vez se muere. Reproducir este partón en la clase
                if(state=="Shell"){
    				die()
				} else{
    			state = "Shell"
				}
            }
            "Enemy" -> changeDirection()
        }
    }
}

    
    
//4 A partir de la clase Koopa, crear la clase de Koopas voladores (Koopa paratroopa). Su estado inicial es Volando, al colisionar por primera vez camina, a la segunda se vuelve concha y a la tercera muere.
class KoopaParatroopa: Koopa() {

    init{
        state="Flying"
    }
    
    override fun collision(collider: String){
        when(collider){
            "Weapon" -> {
                if(state=="Shell"){die()}
                else if(state=="Walking"){state = "Shell"} 
                else{state = "Walking"}
            }
            "Enemy" -> changeDirection()
        }
    }
}
