# News Feed Simulator — Kotlin Coroutines & Flow (Pertemuan 2)

**Nama:** Muhammad Rafly Yahya Ramadhan  **NIM:** 123140148
Mata kuliah Pengembangan Aplikasi Mobile (IF25-22017) — ITERA

Aplikasi console (JVM) yang mensimulasikan feed berita. Kodenya ada di modul `newsfeed/`.

## Fitur → file
| # | Fitur | File |
|---|-------|------|
| 1 | Flow berita baru setiap 2 detik | `NewsFeed.kt` (`newsFlow`) |
| 2 | Filter berdasarkan kategori | `NewsFeed.kt` (`filterByCategories`) |
| 3 | Transform ke format tampilan | `NewsModels.kt` (`toDisplayString`) |
| 4 | StateFlow jumlah berita dibaca | `ReadTracker.kt` |
| 5 | Ambil detail berita async (`async/await`, `Dispatchers.IO`) | `NewsRepository.kt` |
| Bonus | `.catch` error handling + unit test | `Main.kt`, `NewsFeedTest.kt` |

## Cara menjalankan
Butuh JDK 11+ (disarankan 17).
```
./gradlew :newsfeed:run          # Windows: gradlew.bat :newsfeed:run
```
Atau buka folder ini di IntelliJ/Android Studio, lalu jalankan `main()` di `Main.kt`.

## Menjalankan unit test
```
./gradlew :newsfeed:test
```

## Contoh output
```
=== News Feed Simulator ===
Kategori dipantau: Teknologi, Ekonomi, Kesehatan
[FLOW] Berita masuk: id=2
📰 [#2] [TEKNOLOGI] Compose Multiplatform rilis fitur terbaru
   📖 Total berita dibaca: 1
```
> Folder `shared/` dan `androidApp/` hanya template bawaan project KMP dan tidak dipakai untuk tugas ini.
