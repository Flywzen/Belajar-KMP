# Hands-on Pertemuan 7 (Kotlin Dasar) — Asynchronous Programming in Kotlin

Implementasi latihan ada di tiga modul `handson1-latihan` sampai `handson3-latihan`. Deskripsi soal asli disimpan di [SOAL.md](SOAL.md); status pemeriksaan ada di [VERIFIKASI.md](../VERIFIKASI.md).

## Menjalankan

Buka folder ini sebagai proyek Gradle terpisah di IntelliJ IDEA atau Android Studio. Gunakan JDK 17.

Jalankan `./gradlew :handson1-latihan:run`; ganti angka 1 dengan 2 atau 3 untuk latihan lainnya. Di Windows, gunakan `gradlew.bat` menggantikan `./gradlew`.

## Daftar Latihan

### 1. `handson1-latihan` — Suspend Function Dasar
Buat `suspend fun checkOrderStatus()` yang mensimulasikan panggilan server (delay 2 detik), lalu panggil dari dalam `runBlocking` tanpa memblokir thread OS.

- **Konsep:** `suspend fun`, `delay`, "suspend function hanya bisa dipanggil dari coroutine atau suspend fun lain".

### 2. `handson2-latihan` — launch vs async
Ada 2 tugas simulasi (logging & menghitung total harga). Pilih coroutine builder yang tepat: `launch` untuk tugas tanpa nilai balik, `async`/`await` untuk tugas yang hasilnya dibutuhkan.

- **Konsep:** `launch`, `Job`, `async`, `Deferred`, `await()`.

### 3. `handson3-latihan` — Structured Concurrency & Cancellation
Implementasikan `DownloadManager` yang menjalankan beberapa "download" sebagai child coroutine dari satu parent `Job`. Batalkan parent `Job` dan buktikan seluruh child yang belum selesai ikut berhenti.

- **Konsep:** `Job()`, `CoroutineScope`, parent-child job hierarchy, `cancel()`.

## Catatan

`delay` menangguhkan coroutine; `runBlocking` tetap menahan thread pemanggil sampai selesai. Pada latihan 3, pembatalan di 1200 ms normalnya menyisakan foto (1000 ms) selesai, sementara dokumen (1500 ms) dan video (3000 ms) dibatalkan.
