# Hands-on Pertemuan 10 (Kotlin Dasar) — Build Systems

Implementasi latihan ada di tiga modul `handson1-latihan` sampai `handson3-latihan`. Deskripsi soal asli disimpan di [SOAL.md](SOAL.md); status pemeriksaan ada di [VERIFIKASI.md](../VERIFIKASI.md).

## Menjalankan

Buka folder ini sebagai proyek Gradle terpisah di IntelliJ IDEA atau Android Studio. Gunakan JDK 17.

Jalankan `./gradlew :handson1-latihan:run`; ganti angka 1 dengan 2 atau 3 untuk latihan lainnya. Di Windows, gunakan `gradlew.bat` menggantikan `./gradlew`.

Latihan 2 diuji lewat `./gradlew :handson2-latihan:printProjectInfo`. Resource latihan 1 ikut dipaketkan melalui `src/main/resources`; dependency datetime latihan 3 sudah dideklarasikan.

## Daftar Latihan

### 1. `handson1-latihan` — Resource & Packaging
Baca file `app.properties` yang ditaruh di `src/main/resources` lewat classloader (`getResourceAsStream`), lalu tampilkan isinya.

- **Konsep:** Gradle resource convention, classpath, `java.util.Properties`.

### 2. `handson2-latihan` — Custom Gradle Task
Lengkapi custom task `printProjectInfo` di `build.gradle.kts` supaya mencetak nama project, versi project, dan versi Gradle saat dijalankan lewat `./gradlew`.

- **Konsep:** `tasks.register`, `doLast`, configuration vs execution phase.

### 3. `handson3-latihan` — Dependency Declaration
Tambahkan dependency `kotlinx-datetime` ke `build.gradle.kts` module ini supaya `Latihan.kt` (yang sudah lengkap) bisa resolve dan mencetak tanggal hari ini.

- **Konsep:** `dependencies {}`, koordinat `groupId:artifactId:version`, `implementation` vs `api`.
