fun main() {
    
    val mario = Mario()

    if(mario.isAlive){
    mario.collision("Goomba")
    println("Tienes ${mario.getLives()}")
    mario.collision("Star")
	}
	}

class Mario(var vidas: Int =3){ //vamos a dejar setear el número de vidas al iniciar el objeto Mario

    init {
        println("It's a me! Mario!") //vamos a hacer que Mario se presente al construirlo!
    }

    //1 Crear un atributo Booleano que nos permita saber si aún seguimos vivos, la variable debe ser únicamente de lectura. Utilizaremos ese valor para elegir si colisionar con un Goomba en el ciclo for.
    val isAlive: Boolean
	get() {return lives>0}
    private var state = "small" //mario es pequeño al iniciar el juego
    //2Crear el caso de la estrella en el colisionador, crear el setter y reproducir la función en main.kt
    set(value) {
    val before = field
    field = value
    println("tu estado ahora es $field")
    if(value=="Star"){
        Timer("SettingUp", false).schedule(10000) {
            field = before
            println("tu estado ahora es $field")
        }
    }
    field = value
	}
    private var lives = 3 //uno empieza el juego con tres vidas
        set(value){
            when (field) {
                1 -> {
                    field = 0
                    gameOver()
                }
                0 -> {
                    println("Reinicia el juego!!!")
                }
                else -> {
                    field = value
                }
            }
        }
        

    //resta una vida al jugador
    private fun die(){
        lives--
        println("Has perdido una vida!")
    }

    fun getLives(): String{
        return "$lives vidas"
    }

    private fun gameOver(){
        println("Juego finalizado")
    }

    //el modificador public es redundante
    //en función del objeto colisionante, se ejecuta un evento
    public fun collision(collisionObj: String){
        when(collisionObj){
            "Goomba" -> lives--//die()
            "Super Mushroom" -> state = "Super mario"
            "Fire flower" -> {
                state = "Fire mario"
                println("El estado de mario es $state")
            }
            //Crear el caso de la estrella en el colisionador, crear el setter y reproducir la función en main.kt
            "Star" -> state = "Star"
            else -> println("Objeto desconocido ¡no pasa nada!")
        }
    }
}
