# Hands-on Pertemuan 1 — Introduction to Kotlin

Implementasi latihan ada di tiga modul `handson1-latihan` sampai `handson3-latihan`. Deskripsi soal asli disimpan di [SOAL.md](SOAL.md); status pemeriksaan ada di [VERIFIKASI.md](../VERIFIKASI.md).

## Menjalankan

Buka folder ini sebagai proyek Gradle terpisah di IntelliJ IDEA atau Android Studio. Gunakan JDK 17.

Jalankan `./gradlew :handson1-latihan:run`; ganti angka 1 dengan 2 atau 3 untuk latihan lainnya. Di Windows, gunakan `gradlew.bat` menggantikan `./gradlew`.

## Daftar Latihan

### 1. `handson1-latihan` — Variabel, Fungsi & String Template
Lengkapi `describeProfile()` yang mencetak deskripsi profil menggunakan string template, default parameter, dan penanganan nilai `Int?` yang mungkin null.

- **Konsep:** `val`/`var`, string template (`$var`, `${expr}`), default parameter, named argument, safe call (`?.`), elvis operator (`?:`).

### 2. `handson2-latihan` — Control Flow dengan `when` Expression
Lengkapi `gradeOf()` yang mengklasifikasikan nilai ujian (0-100) menjadi huruf mutu A-E menggunakan `when` sebagai **expression** dalam single-expression function.

- **Konsep:** `when` sebagai expression, range (`in 90..100`), single-expression function (`fun ... = ...`).

### 3. `handson3-latihan` — Loops, Ranges & Null Safety
Lengkapi `ScoreBoard` agar bisa menyaring skor valid (membuang `null`) yang memenuhi batas kelulusan, lalu cetak bilangan ganjil menggunakan range ber-`step`.

- **Konsep:** `filterNotNull()`, `filter`, `sortedDescending()`, range dengan `step`, class dengan constructor property.
