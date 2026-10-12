# Hands-on Pertemuan 5 (Kotlin Dasar) — Functional Programming

Implementasi latihan ada di tiga modul `handson1-latihan` sampai `handson3-latihan`. Deskripsi soal asli disimpan di [SOAL.md](SOAL.md); status pemeriksaan ada di [VERIFIKASI.md](../VERIFIKASI.md).

## Menjalankan

Buka folder ini sebagai proyek Gradle terpisah di IntelliJ IDEA atau Android Studio. Gunakan JDK 17.

Jalankan `./gradlew :handson1-latihan:run`; ganti angka 1 dengan 2 atau 3 untuk latihan lainnya. Di Windows, gunakan `gradlew.bat` menggantikan `./gradlew`.

## Daftar Latihan

### 1. `handson1-latihan` — Higher-Order Function
Lengkapi fungsi `calculate(a, b, operation)` yang menjalankan `operation` terhadap dua angka, lalu panggil dengan lambda berbeda (tambah, kurang, kali) tanpa mengubah signature fungsinya.

- **Konsep:** higher-order function, function type `(Int, Int) -> Int`, trailing lambda syntax.

### 2. `handson2-latihan` — Lambda & Function Reference
Bangun 2 pipeline `filter` + `map` terhadap list nama mahasiswa: satu memakai lambda inline, satu lagi memakai function reference (`::isEvenLength`, `::toUpper`). Hasil keduanya harus identik.

- **Konsep:** lambda expression, function reference (`::`), functions sebagai first-class citizen.

### 3. `handson3-latihan` — Closure (Counter Factory)
Implementasikan `makeCounter(): () -> Int` yang mengembalikan closure — sebuah lambda yang mengingat (capture) variabel `count` di luar scope `makeCounter`, dan bertambah setiap kali dipanggil.

- **Konsep:** closure, variable capturing, state tersembunyi pada fungsi.
