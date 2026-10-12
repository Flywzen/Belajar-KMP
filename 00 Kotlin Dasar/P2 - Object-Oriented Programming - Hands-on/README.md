# Hands-on Pertemuan 2 (Kotlin Dasar) — Object-Oriented Programming

Implementasi latihan ada di tiga modul `handson1-latihan` sampai `handson3-latihan`. Deskripsi soal asli disimpan di [SOAL.md](SOAL.md); status pemeriksaan ada di [VERIFIKASI.md](../VERIFIKASI.md).

## Menjalankan

Buka folder ini sebagai proyek Gradle terpisah di IntelliJ IDEA atau Android Studio. Gunakan JDK 17.

Jalankan `./gradlew :handson1-latihan:run`; ganti angka 1 dengan 2 atau 3 untuk latihan lainnya. Di Windows, gunakan `gradlew.bat` menggantikan `./gradlew`.

## Daftar Latihan

### 1. `handson1-latihan` — Class & Inheritance
Buat hierarki class `Vehicle` (open class) dengan turunan `Car` dan `Motorcycle` yang meng-override `describe()` untuk menambahkan info spesifik masing-masing kendaraan.

- **Konsep:** `open class`, `override`, primary constructor, `super`, polymorphism lewat `List<Vehicle>`.

### 2. `handson2-latihan` — Interface & Data Class
Buat interface `Payable` dengan `calculateSalary()`, implementasikan lewat `data class Employee`. Manfaatkan `copy()` untuk membuat variasi objek dan `equals()` bawaan untuk membandingkan berdasarkan isi (bukan referensi).

- **Konsep:** `interface`, `data class`, `copy()`, `equals()`/`toString()` otomatis.

### 3. `handson3-latihan` — Sealed Class untuk State
Modelkan hasil pemanggilan network sebagai `sealed class NetworkResult` dengan 3 state: `Loading` (object), `Success` (data class), dan `Error` (data class), lalu tangani semuanya dengan `when` yang exhaustive.

- **Konsep:** `sealed class`, `object` sebagai singleton, `when` exhaustive tanpa `else`.
