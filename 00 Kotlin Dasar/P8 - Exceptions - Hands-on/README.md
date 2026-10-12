# Hands-on Pertemuan 8 (Kotlin Dasar) — Exceptions

Implementasi latihan ada di tiga modul `handson1-latihan` sampai `handson3-latihan`. Deskripsi soal asli disimpan di [SOAL.md](SOAL.md); status pemeriksaan ada di [VERIFIKASI.md](../VERIFIKASI.md).

## Menjalankan

Buka folder ini sebagai proyek Gradle terpisah di IntelliJ IDEA atau Android Studio. Gunakan JDK 17.

Jalankan `./gradlew :handson1-latihan:run`; ganti angka 1 dengan 2 atau 3 untuk latihan lainnya. Di Windows, gunakan `gradlew.bat` menggantikan `./gradlew`.

## Daftar Latihan

### 1. `handson1-latihan` — Try-Catch-Finally Dasar
Lengkapi fungsi `safeDivide(a, b)` agar menangani `ArithmeticException` (pembagian dengan nol) tanpa membuat program crash, dan memastikan blok `finally` selalu tereksekusi.

- **Konsep:** `try`, `catch`, `finally`, `ArithmeticException`.

### 2. `handson2-latihan` — Custom Exception & Exception Hierarchy
Buat `class InsufficientBalanceException : Exception` untuk kasus saldo tidak cukup pada `BankAccount.withdraw()`, lalu tangani secara spesifik di pemanggilnya tanpa menghentikan program.

- **Konsep:** custom exception class, exception hierarchy (`Throwable` → `Exception`), `require()`.

### 3. `handson3-latihan` — Kotlin Sugar: try-expression, require(), error(), multi-catch
Implementasikan `parseTiket(input: String): Tiket` yang mem-parsing teks `"nama/umur"` menggunakan `try` sebagai *expression*, `require()` untuk validasi input, dan `error()` untuk kondisi yang seharusnya tidak terjadi, lalu tangani hasilnya dengan multi-catch di `main()`.

- **Konsep:** `try` sebagai expression, `require()` → `IllegalArgumentException`, `error()` → `IllegalStateException`, multi-catch.
