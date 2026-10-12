/**
 * Model data untuk News Feed Simulator.
 * Data class dipakai karena hanya menyimpan data (boilerplate minimal).
 */
enum class NewsCategory(val label: String) {
    TEKNOLOGI("Teknologi"),
    OLAHRAGA("Olahraga"),
    EKONOMI("Ekonomi"),
    HIBURAN("Hiburan"),
    KESEHATAN("Kesehatan")
}

data class News(
    val id: Int,
    val title: String,
    val category: NewsCategory
)

data class NewsDetail(
    val newsId: Int,
    val author: String,
    val content: String
)

data class FullNews(
    val detail: NewsDetail,
    val commentCount: Int
)

// ---------- Extension functions (Transform ke format tampilan) ----------

fun News.toDisplayString(): String =
    "📰 [#${id}] [${category.label.uppercase()}] $title"

fun FullNews.toDisplayString(): String =
    "   ↳ Detail #${detail.newsId} oleh ${detail.author}: \"${detail.content}\" (💬 $commentCount komentar)"
