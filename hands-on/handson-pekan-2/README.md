# Hands-on P2 — Coroutines dan Flow

Proyek Kotlin/JVM, satu modul per latihan:

1. `handson1-latihan`: ambil profil dan postingan dengan `async`/`await` secara paralel. Targetnya sekitar 1 detik, bukan 1,8 detik.
2. `handson2-latihan`: flow sensor suhu, difilter > 30°C, lalu `map` jadi pesan warning.
3. `handson3-latihan`: `CounterManager` dengan `StateFlow` (increment, decrement minimum 0, reset).

## Menjalankan
Buka folder ini di Android Studio, tunggu sync, lalu jalankan `main()` di `Latihan.kt` pada modul yang dipilih. Belum ada Gradle wrapper di folder ini.
