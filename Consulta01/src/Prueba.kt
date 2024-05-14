import java.util.concurrent.ArrayBlockingQueue

fun main() {

    // Colaboración entre Hilos
    /*
    // Uso de join
    val hilo1 = Thread {
        println("Hilo 1 iniciado")
        Thread.sleep(3000) // Simulando una tarea larga
        println("Hilo 1 finalizado")
    }

    val hilo2 = Thread {
        println("Hilo 2 iniciado")
        Thread.sleep(2000) // Simulando una tarea larga
        println("Hilo 2 finalizado")
    }

    hilo1.start()
    hilo2.start()

    // Esperar a que los hilos finalicen


    println("Hilos finalizados, continuando con el programa principal")
     */

    // Colas concurrentes
    /*
    val cola = ArrayBlockingQueue<Int>(10)

    // Hilos productores
    for (i in 1..10) {
        Thread {
            cola.put(i)
            println("Producido: $i")
        }.start()
    }

    // Hilos consumidores
    for (i in 1..10) {
        Thread {
            val valor = cola.take()
            println("Consumido: $valor")
        }.start()
    }
     */

    // Variables compartidas
    /*
    val compartida = PruebaVarCompartida()

    for (i in 1 until  11) {
        Thread {
            compartida.incrementCount()
            println("Hilo ${Thread.currentThread().name} - Count: ${compartida.getCount()}")
        }.start()
    }
     */

    // Creación de Hilos
    // Metodo 1
    /*
    for (i in 1 until 5) {
        val clase = PruebaHilo()
        val hilo = Thread(clase)
        hilo.start()
    }
     */

    // Metodo 2
    /*
    for (i in 1 until 5) {
        val clase = PruebaHilo()
        clase.start()
    }
     */

    // Metodo 3
    /*
    for (i in 1 until  5) {
        Thread {
            println("Hilo: " + Thread.currentThread().name)
        }.start()
    }
    */
}