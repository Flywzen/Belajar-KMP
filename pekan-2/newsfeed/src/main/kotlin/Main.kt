import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * News Feed Simulator
 * Nama : Muhammad Rafly Yahya Ramadhan
 * NIM  : 123140148
 */
fun main() = runBlocking {
    // Kategori yang ingin diikuti user
    val selectedCategories = setOf(NewsCategory.TEKNOLOGI, NewsCategory.EKONOMI, NewsCategory.KESEHATAN)

    val repository = NewsRepository()
    val tracker = ReadTracker()

    println("=== News Feed Simulator ===")
    println("Kategori dipantau: ${selectedCategories.joinToString { it.label }}")
    println("Menunggu berita baru (1 berita / 2 detik)...\n")

    // Observer StateFlow: tampilkan jumlah berita yang sudah dibaca setiap kali berubah
    val readObserver = launch {
        tracker.readCount.collect { count ->
            println("   📖 Total berita dibaca: $count")
        }
    }

    // coroutineScope menunggu semua child coroutine (launch di bawah) selesai
    coroutineScope {
        newsFlow(total = 10)                                  // 1. Flow berita baru tiap 2 detik
            .filterByCategories(selectedCategories)           // 2. Filter kategori
            .onEach { println("\n[FLOW] Berita masuk: id=${it.id}") } // side effect
            .catch { e -> println("\n⚠️ Error pada feed: ${e.message}") } // bonus: error handling
            .collect { news ->
                println(news.toDisplayString())               // 3. Transform ke format tampilan

                // 5. Ambil detail secara async tanpa memblokir feed berikutnya
                launch {
                    try {
                        val full = repository.loadFullDetail(news)
                        println(full.toDisplayString())
                        tracker.markAsRead()                  // 4. Update StateFlow
                    } catch (e: CancellationException) {
                        throw e                               // jangan telan cancellation
                    } catch (e: Exception) {
                        println("   ⚠️ Gagal memuat detail #${news.id}: ${e.message}")
                    }
                }
            }
    }

    // StateFlow tidak pernah selesai, jadi observer harus dihentikan manual
    readObserver.cancelAndJoin()
    println("\n✅ Feed selesai. Total berita dibaca: ${tracker.readCount.value}")
}
