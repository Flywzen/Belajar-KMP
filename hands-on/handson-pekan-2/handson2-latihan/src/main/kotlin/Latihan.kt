import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

// Hands-on 2: Flow dengan Operators
// Tugas: Buat Flow yang mensimulasikan sensor suhu, filter suhu di atas 30°C,
// dan tampilkan warning dengan format yang bagus.

fun temperatureSensor(): Flow<Int> = flow {
    repeat(10) {
        delay(500)
        val temp = Random.nextInt(20, 40) // Random 20-39°C
        emit(temp)
    }
}

fun main() = runBlocking {
    temperatureSensor()
        .filter { temp -> temp > 30 }                                   // cuma ambil suhu di atas 30°C
        .map { temp -> "⚠️ WARNING: Suhu tinggi terdeteksi: ${temp}°C" } // Int jadi String warning
        .onEach { println("Processing warning...") }                    // side effect, datanya ga berubah
        .collect { warning -> println(warning) }                        // terminal operator, ini yang bikin flow jalan
}
