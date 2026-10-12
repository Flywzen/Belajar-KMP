import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// Hands-on 3: StateFlow untuk Counter
// Tugas: Implementasikan counter sederhana menggunakan StateFlow.
// Counter harus bisa increment, decrement, dan reset.

class CounterManager {
    // privat, cuma kelas ini yang boleh ngubah nilainya. awal 0
    private val _count = MutableStateFlow(0)

    // versi read-only buat dibaca dari luar
    val count: StateFlow<Int> = _count.asStateFlow()

    fun increment() {
        _count.update { it + 1 }
    }

    fun decrement() {
        // minimal 0, jadi cuma dikurangi kalau masih di atas 0
        _count.update { if (it > 0) it - 1 else it }
    }

    fun reset() {
        _count.value = 0
    }
}

fun main() = runBlocking {
    val counter = CounterManager()

    // Collect di background
    val job = launch {
        counter.count.collect { println("Count: $it") }
    }

    delay(100)
    counter.increment() // Count: 1
    delay(100)
    counter.increment() // Count: 2
    delay(100)
    counter.decrement() // Count: 1
    delay(100)
    counter.reset()     // Count: 0
    delay(100)

    job.cancel()
}
