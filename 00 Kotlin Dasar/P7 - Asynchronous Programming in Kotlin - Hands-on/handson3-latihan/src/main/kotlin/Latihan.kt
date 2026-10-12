import kotlinx.coroutines.*

class DownloadManager(private val scope: CoroutineScope) {
    fun downloadFile(name: String, durationMs: Long): Job = scope.launch {
        delay(durationMs)
        println("$name selesai di-download")
    }
}

fun main() = runBlocking {
    val parentJob = Job()
    val scope = CoroutineScope(parentJob)
    val manager = DownloadManager(scope)
    try {
        manager.downloadFile("foto.jpg", 1000)
        manager.downloadFile("video.mp4", 3000)
        manager.downloadFile("dokumen.pdf", 1500)
        delay(1200) // Normalnya baru foto selesai; dokumen dan video masih berjalan.
        println("Membatalkan sisa download...")
        parentJob.cancel()
        parentJob.join()
        delay(2000)
        println("Selesai.")
    } finally {
        parentJob.cancel()
    }
}
