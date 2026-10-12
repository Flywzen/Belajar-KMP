import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

private val sampleTitles = mapOf(
    NewsCategory.TEKNOLOGI to listOf(
        "Kotlin Multiplatform makin populer di industri",
        "Compose Multiplatform rilis fitur terbaru",
        "AI generatif ubah cara developer bekerja"
    ),
    NewsCategory.OLAHRAGA to listOf(
        "Timnas berhasil lolos ke babak final",
        "Turnamen bulu tangkis nasional resmi dibuka"
    ),
    NewsCategory.EKONOMI to listOf(
        "Rupiah menguat terhadap dolar AS",
        "Startup lokal raih pendanaan seri B"
    ),
    NewsCategory.HIBURAN to listOf(
        "Film animasi lokal tembus sejuta penonton",
        "Konser musik akbar digelar akhir pekan ini"
    ),
    NewsCategory.KESEHATAN to listOf(
        "Tips menjaga kesehatan mata saat coding",
        "Pentingnya tidur cukup bagi mahasiswa"
    )
)

/**
 * 1. FLOW yang mensimulasikan berita baru setiap [intervalMs] milidetik (default 2 detik).
 *
 * @param failAtId jika diisi, flow akan melempar exception di berita ke-N (untuk demo/test error handling)
 */
fun newsFlow(
    intervalMs: Long = 2_000L,
    total: Int = 10,
    random: Random = Random.Default,
    failAtId: Int? = null
): Flow<News> = flow {
    for (id in 1..total) {
        delay(intervalMs)                       // simulasi berita baru datang
        if (id == failAtId) error("Koneksi feed terputus pada berita #$id")

        val category = NewsCategory.entries[random.nextInt(NewsCategory.entries.size)]
        val title = sampleTitles.getValue(category).random(random)
        emit(News(id = id, title = title, category = category))
    }
}

/**
 * 2. FILTER berdasarkan kategori (higher-order / extension function pada Flow).
 */
fun Flow<News>.filterByCategories(categories: Set<NewsCategory>): Flow<News> =
    filter { it.category in categories }
