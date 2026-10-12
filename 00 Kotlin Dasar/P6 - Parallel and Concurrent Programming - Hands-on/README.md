# Hands-on Pertemuan 6 (Kotlin Dasar) — Parallel and Concurrent Programming

Implementasi latihan ada di tiga modul `handson1-latihan` sampai `handson3-latihan`. Deskripsi soal asli disimpan di [SOAL.md](SOAL.md); status pemeriksaan ada di [VERIFIKASI.md](../VERIFIKASI.md).

## Menjalankan

Buka folder ini sebagai proyek Gradle terpisah di IntelliJ IDEA atau Android Studio. Gunakan JDK 17.

Jalankan `./gradlew :handson1-latihan:run`; ganti angka 1 dengan 2 atau 3 untuk latihan lainnya. Di Windows, gunakan `gradlew.bat` menggantikan `./gradlew`.

## Daftar Latihan

### 1. `handson1-latihan` — Race Condition
Dua thread meng-increment shared `Counter` sebanyak 100.000x masing-masing secara bersamaan tanpa sinkronisasi. Buktikan hasil akhirnya sering **salah** (bukan 200.000), lalu perbaiki dengan `synchronized`.

- **Target:** hasil akhir SELALU tepat 200.000, walau dijalankan berkali-kali.
- **Konsep:** race condition, shared mutable state, `synchronized`, intrinsic lock (monitor).

### 2. `handson2-latihan` — ExecutorService & Future
Jalankan 4 perhitungan "berat" (disimulasikan dengan `Thread.sleep`) secara paralel menggunakan thread pool, kumpulkan hasilnya dengan `Future.get()`.

- **Target:** total waktu eksekusi ~1000ms (bukan ~4000ms jika sequential).
- **Konsep:** `Executors.newFixedThreadPool`, `Callable`, `Future`, `shutdown()`.

### 3. `handson3-latihan` — Producer-Consumer dengan BlockingQueue
Implementasikan pola producer-consumer: satu thread menaruh pesan ke `LinkedBlockingQueue`, satu thread lain mengambil dan mencetaknya, berhenti saat menerima sentinel value.

- **Konsep:** `LinkedBlockingQueue`, `put()`/`take()` (blocking), sentinel value.

## Catatan

Urutan log producer dan consumer dapat berbeda antar-run. Yang harus tetap benar adalah urutan pesan yang diambil consumer dan penghentian setelah sentinel.
