// Ejemplo realizado por Claude AI

// Clase validadora y contadora de numeros primos de una seccion de la lista
class PrimeCounterThread(private val numbers: IntArray,
                         private val start: Int, private val end: Int) : Thread() {
    private var primeCount: Int = 0 // Contador de los numeros primos

    // Metodo run de la clase heredada Thread
    override fun run() {
        // Iterar desde y hasta las posiciones de la lista especificadas
        for (i in start..end) {
            if (i >= numbers.size) break // En caso de llegar al final de toda la lista terminar la iteración
            if (isPrime(numbers[i])) { // Validar si cada numero de la porcion de lista es primo
                primeCount++ // Sumar los si hay primos
            }
        }
    }

    // Obtener la suma de numeros primos
    fun getPrimeCount(): Int {
        return primeCount
    }

    // Metodo para validar si un numero es primo
    private fun isPrime(n: Int): Boolean {
        // Los números menores o iguales a 1 no son primos
        if (n <= 1) return false

        // Iterar desde 2 hasta el número dado menos 1
        for (i in 2..n-1) {
            if (n % i == 0) { // Si el número es divisible por i, no es primo
                return false
            }
        }

        // El número es primo si no se encontró ningún divisor
        return true
    }
}

// Clase Main
fun main() {
    // Lista de números a validar
    val numbers = intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    val numThreads = 4 // Número de hilos que validarán y contarán
    val numbersPerThread = numbers.size / numThreads // Cantidad de números asignados a cada hilo

    val threadList = mutableListOf<PrimeCounterThread>() // Lista que almacenará los hilos
    var start = 0 // Posición de la lista desde la que empieza a validar cada uno de los hilos
    var totalPrimeCount = 0 // Total de números primos entre todos los hilos

    // Recorrer el número de hilos a ejecutarse
    for (i in 0 until numThreads) {
        val end = start + numbersPerThread - 1 // Posición de la lista hasta la que valida cada uno de los hilos
        // Cada hilo que recibe los numeros, el inicio y el fin de la porcion de la lista a validar
        val thread = PrimeCounterThread(numbers, start, end)
        threadList.add(thread) // Añadir el hilo a la lista para conservar sus valores
        thread.start() // Iniciar la ejecución de cada hilo
        start = end + 1 // Actualizar el inicio de la porcion de la lista para el hilo siguiente
    }

    // Recorrer los hilos ya almacenados en la lista
    for (thread in threadList) {
        thread.join() // Hacer un join para alguno de los hilos hasta que todos tengan la suma de los primos
        totalPrimeCount += thread.getPrimeCount() // Suma total de los primos de cada hilo
    }

    // Mensaje en pantalla
    println("Cantidad de números primos en el arreglo: $totalPrimeCount")
}