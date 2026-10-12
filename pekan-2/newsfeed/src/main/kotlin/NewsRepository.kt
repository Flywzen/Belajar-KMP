import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * 5. COROUTINES untuk mengambil detail berita secara async.
 *
 * Dispatcher di-inject lewat constructor supaya mudah di-test
 * (di test kita ganti dengan TestDispatcher).
 */
class NewsRepository(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private val authors = listOf("Budi Santoso", "Siti Aminah", "Rafly Yahya", "Dewi Lestari")

    suspend fun fetchNewsDetail(news: News): NewsDetail = withContext(ioDispatcher) {
        delay(1_000L) // simulasi network call
        NewsDetail(
            newsId = news.id,
            author = authors[news.id % authors.size],
            content = "Isi lengkap berita '${news.title}'"
        )
    }

    suspend fun fetchCommentCount(newsId: Int): Int = withContext(ioDispatcher) {
        delay(800L) // simulasi network call
        (newsId * 7) % 25
    }

    /**
     * Ambil detail + jumlah komentar SECARA PARALEL dengan async/await.
     * Total waktu ~1000ms (bukan 1800ms).
     */
    suspend fun loadFullDetail(news: News): FullNews = coroutineScope {
        val detailDeferred = async { fetchNewsDetail(news) }
        val commentsDeferred = async { fetchCommentCount(news.id) }
        FullNews(detailDeferred.await(), commentsDeferred.await())
    }
}
