// Ejemplo realizado por Claude AI
class PrimeCounterThread(private val numbers: IntArray, private val start: Int, private val end: Int) : Thread() {
    private var primeCount: Int = 0

    override fun run() {
        for (i in start..end) {
            if (i >= numbers.size) break
            if (isPrime(numbers[i])) {
                primeCount++
            }
        }
    }

    fun getPrimeCount(): Int {
        return primeCount
    }

    private fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        if (n == 2 || n == 3) return true
        if (n % 2 == 0 || n % 3 == 0) return false

        var i = 5
        val sqrt = Math.sqrt(n.toDouble()).toInt()

        while (i <= sqrt) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false
            }
            i += 6
        }

        return true
    }
}

fun main() {
    val numbers = intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    val numThreads = 4
    val numbersPerThread = numbers.size / numThreads

    val threadList = mutableListOf<PrimeCounterThread>()
    var start = 0
    var totalPrimeCount = 0

    for (i in 0 until numThreads) {
        val end = start + numbersPerThread - 1
        val thread = PrimeCounterThread(numbers, start, end)
        threadList.add(thread)
        thread.start()
        start = end + 1
    }

    for (thread in threadList) {
        thread.join()
        totalPrimeCount += thread.getPrimeCount()
    }

    println("Cantidad de números primos en el arreglo: $totalPrimeCount")
}