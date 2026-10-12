# P2 — Coroutines dan Flow

Tiga latihan sudah diisi. Masing-masing ada di modul terpisah:

- `handson1-latihan`: dua request dengan `async`/`await`. Delay 1000 ms dan 800 ms berjalan bersamaan, jadi target totalnya sekitar 1 detik. Batas < 2 detik saja belum membuktikan paralel, karena versi sequential juga sekitar 1,8 detik.
- `handson2-latihan`: sensor mengirim 10 suhu acak (20–39°C), satu tiap 500 ms. Hanya suhu > 30°C yang masuk ke warning. Format warning dipertahankan.
- `handson3-latihan`: counter memakai `MutableStateFlow` private dan `StateFlow` publik. Decrement berhenti di 0, reset kembali ke 0.

## Menjalankan

Buka folder ini di Android Studio sebagai proyek Gradle terpisah, tunggu sync, lalu jalankan `main()` dari file `Latihan.kt` pada modul yang dipilih.

Paket ini belum menyertakan Gradle wrapper (`gradlew`). Jika ingin menjalankan lewat terminal, gunakan instalasi Gradle yang kompatibel atau buat wrapper terlebih dahulu.

Nama dan postingan di latihan pertama hanya data contoh. Latihan sensor tetap memakai format output semula.
