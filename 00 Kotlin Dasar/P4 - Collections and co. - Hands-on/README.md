# Hands-on Pertemuan 4 (Kotlin Dasar) — Collections and Co.

Implementasi latihan ada di tiga modul `handson1-latihan` sampai `handson3-latihan`. Deskripsi soal asli disimpan di [SOAL.md](SOAL.md); status pemeriksaan ada di [VERIFIKASI.md](../VERIFIKASI.md).

## Menjalankan

Buka folder ini sebagai proyek Gradle terpisah di IntelliJ IDEA atau Android Studio. Gunakan JDK 17.

Jalankan `./gradlew :handson1-latihan:run`; ganti angka 1 dengan 2 atau 3 untuk latihan lainnya. Di Windows, gunakan `gradlew.bat` menggantikan `./gradlew`.

## Daftar Latihan

### 1. `handson1-latihan` — Transformasi Collection
Dari daftar `Product` (nama, harga, stok), hasilkan daftar **nama** produk yang harganya di atas threshold tertentu, terurut dari yang termurah.

- **Konsep:** `filter`, `sortedBy`, `map`.

### 2. `handson2-latihan` — Grouping & Aggregation
Dari daftar `Transaksi` (id, kategori, nominal), hitung total nominal per kategori, dan buat index pencarian transaksi berdasarkan ID.

- **Konsep:** `groupBy`, `mapValues`, `sumOf`, `associateBy`.

### 3. `handson3-latihan` — Sequence vs List (Lazy Evaluation)
Bandingkan performa pipeline `filter -> map -> take(5)` pada 1 juta angka menggunakan `List` biasa (eager) vs `Sequence` (lazy).

- **Konsep:** `asSequence()`, evaluasi lazy vs eager, terminal operation (`toList()`).

## Catatan

Angka waktu pada latihan Sequence bergantung pada mesin dan pemanasan JVM. Satu kali pengukuran belum cukup untuk klaim benchmark umum.
