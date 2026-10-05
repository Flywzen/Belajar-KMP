import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class NewsFeedTest {

    @Test
    fun `newsFlow memancarkan jumlah berita sesuai total`() = runTest {
        val result = newsFlow(intervalMs = 2_000L, total = 5, random = Random(1)).toList()
        assertEquals(5, result.size)
        assertEquals(listOf(1, 2, 3, 4, 5), result.map { it.id })
        // delay dilewati dengan virtual time: 5 x 2000ms
        assertEquals(10_000L, currentTime)
    }

    @Test
    fun `filterByCategories hanya meloloskan kategori terpilih`() = runTest {
        val source = flowOf(
            News(1, "A", NewsCategory.TEKNOLOGI),
            News(2, "B", NewsCategory.OLAHRAGA),
            News(3, "C", NewsCategory.EKONOMI)
        )
        val result = source.filterByCategories(setOf(NewsCategory.TEKNOLOGI, NewsCategory.EKONOMI)).toList()
        assertEquals(listOf(1, 3), result.map { it.id })
    }

    @Test
    fun `toDisplayString memuat id kategori dan judul`() {
        val text = News(7, "Judul Uji", NewsCategory.EKONOMI).toDisplayString()
        assertTrue("#7" in text)
        assertTrue("EKONOMI" in text)
        assertTrue("Judul Uji" in text)
    }

    @Test
    fun `ReadTracker menambah dan mereset jumlah dibaca`() {
        val tracker = ReadTracker()
        assertEquals(0, tracker.readCount.value)
        tracker.markAsRead()
        tracker.markAsRead()
        assertEquals(2, tracker.readCount.value)
        tracker.reset()
        assertEquals(0, tracker.readCount.value)
    }

    @Test
    fun `loadFullDetail berjalan paralel`() = runTest {
        val repo = NewsRepository(ioDispatcher = StandardTestDispatcher(testScheduler))
        val full = repo.loadFullDetail(News(1, "Judul", NewsCategory.TEKNOLOGI))

        assertEquals(1, full.detail.newsId)
        // paralel: max(1000, 800) = 1000ms, bukan 1800ms
        assertEquals(1_000L, currentTime)
    }

    @Test
    fun `catch menangani error dari flow`() = runTest {
        var error: Throwable? = null
        val result = newsFlow(intervalMs = 100L, total = 5, random = Random(1), failAtId = 3)
            .catch { error = it }
            .toList()

        assertEquals(2, result.size)          // berita 1 & 2 sempat masuk
        assertNotNull(error)
        assertTrue(error!!.message!!.contains("#3"))
    }
}
