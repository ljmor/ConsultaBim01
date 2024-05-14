import kotlin.concurrent.thread

class PruebaHilo: Runnable {

    override fun run() {
        println("Ejecutando hilo: " + Thread.currentThread().name)
    }
}

/* Heredando de Thread
class PruebaHilo: Thread() {

    override fun run() {
        println("Ejecutando hilo: " + Thread.currentThread().name)
    }
}
 */

class PruebaVarCompartida {
    private var count = 0

    @Synchronized
    fun incrementCount() {
        count++
    }

    fun getCount(): Int {
        return count
    }
}