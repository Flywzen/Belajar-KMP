import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun hitungKuadrat(n: Int): Int {
    Thread.sleep(1000)
    return n * n
}

fun main() {
    val angka = listOf(1, 2, 3, 4)
    val startTime = System.currentTimeMillis()
    val executor = Executors.newFixedThreadPool(4)
    try {
        // Submit semuanya dulu. Kalau langsung get(), task berikutnya malah antre.
        val futures = angka.map { n -> executor.submit(Callable { hitungKuadrat(n) }) }
        val hasil = futures.map { it.get() }
        println("Hasil: $hasil")
    } finally {
        executor.shutdown()
    }
    println("Waktu: ${System.currentTimeMillis() - startTime}ms")
}
