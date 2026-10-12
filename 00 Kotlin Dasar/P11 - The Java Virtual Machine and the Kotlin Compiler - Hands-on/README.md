# Hands-on Pertemuan 11 (Kotlin Dasar) — The Java Virtual Machine and the Kotlin Compiler

Implementasi latihan ada di tiga modul `handson1-latihan` sampai `handson3-latihan`. Deskripsi soal asli disimpan di [SOAL.md](SOAL.md); status pemeriksaan ada di [VERIFIKASI.md](../VERIFIKASI.md).

## Menjalankan

Buka folder ini sebagai proyek Gradle terpisah di IntelliJ IDEA atau Android Studio. Gunakan JDK 17.

Jalankan `./gradlew :handson1-latihan:run`; ganti angka 1 dengan 2 atau 3 untuk latihan lainnya. Di Windows, gunakan `gradlew.bat` menggantikan `./gradlew`.

## Daftar Latihan

### 1. `handson1-latihan` — Inline Function & Reified Generics
Lengkapi `isType()` agar bisa memeriksa tipe generik pada runtime menggunakan `value is T`, sesuatu yang mustahil dilakukan pada generic function biasa karena type erasure di JVM.

- **Konsep:** type erasure, `inline`, `reified`.

### 2. `handson2-latihan` — Tailrec Optimization
Ubah fungsi factorial rekursif biasa (yang StackOverflowError untuk n besar) menjadi versi `tailrec` yang dioptimasi compiler menjadi loop, sehingga aman untuk n = 100.000.

- **Konsep:** stack frame JVM, tail call, `tailrec`.

### 3. `handson3-latihan` — companion object & @JvmStatic
Tambahkan `@JvmStatic` pada fungsi di `companion object` agar benar-benar menjadi static method di level bytecode JVM, lalu buktikan lewat `Greeter::class.java.methods` (reflection Java biasa, bukan kotlin-reflect).

- **Konsep:** `companion object`, `@JvmStatic`, interop Java, `java.lang.Class` reflection.

## Catatan

Versi tailrec menghindari stack overflow, tetapi kapasitas Long tetap terbatas. Faktorial besar pada contoh sengaja tidak akurat akibat overflow angka.
