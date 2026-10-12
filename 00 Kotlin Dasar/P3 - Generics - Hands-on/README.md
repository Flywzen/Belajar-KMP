# Hands-on Pertemuan 3 (Kotlin Dasar) — Generics

Implementasi latihan ada di tiga modul `handson1-latihan` sampai `handson3-latihan`. Deskripsi soal asli disimpan di [SOAL.md](SOAL.md); status pemeriksaan ada di [VERIFIKASI.md](../VERIFIKASI.md).

## Menjalankan

Buka folder ini sebagai proyek Gradle terpisah di IntelliJ IDEA atau Android Studio. Gunakan JDK 17.

Jalankan `./gradlew :handson1-latihan:run`; ganti angka 1 dengan 2 atau 3 untuk latihan lainnya. Di Windows, gunakan `gradlew.bat` menggantikan `./gradlew`.

## Daftar Latihan

### 1. `handson1-latihan` — Generic Class `Box<T>`
Lengkapi class generik `Box<T>` dengan fungsi `map<R>(transform: (T) -> R): Box<R>` yang mentransformasikan isi Box menjadi Box baru bertipe berbeda.

- **Konsep:** generic class, type parameter, type inference.

### 2. `handson2-latihan` — Bounded Type Parameter
Implementasikan `findMax` generik yang mencari nilai terbesar dari sebuah `List<T>`, dengan constraint `T : Comparable<T>` agar elemen bisa dibandingkan.

- **Konsep:** bounded type parameter (upper bound), `Comparable<T>`.

### 3. `handson3-latihan` — Variance (`out`)
Tandai `Container<T>` dengan modifier variance yang tepat agar `Container<Cat>` bisa dianggap sebagai `Container<Animal>`.

- **Konsep:** declaration-site variance, covariance (`out`), subtyping generic.
