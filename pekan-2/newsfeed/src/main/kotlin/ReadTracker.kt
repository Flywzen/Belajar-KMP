import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * 4. STATEFLOW untuk menyimpan jumlah berita yang sudah dibaca.
 * - MutableStateFlow (private) -> hanya class ini yang bisa mengubah
 * - StateFlow (public)         -> pihak luar hanya bisa membaca / collect
 */
class ReadTracker {
    private val _readCount = MutableStateFlow(0)
    val readCount: StateFlow<Int> = _readCount.asStateFlow()

    // update {} bersifat atomic, aman jika dipanggil dari banyak coroutine sekaligus
    fun markAsRead() {
        _readCount.update { it + 1 }
    }

    fun reset() {
        _readCount.value = 0
    }
}
