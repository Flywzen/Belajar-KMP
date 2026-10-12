# Hands-on Pertemuan 13 (Kotlin Dasar) — Backend Development Basics

Implementasi latihan ada di tiga modul `handson1-latihan` sampai `handson3-latihan`. Deskripsi soal asli disimpan di [SOAL.md](SOAL.md); status pemeriksaan ada di [VERIFIKASI.md](../VERIFIKASI.md).

## Menjalankan

Buka folder ini sebagai proyek Gradle terpisah di IntelliJ IDEA atau Android Studio. Gunakan JDK 17.

Jalankan `./gradlew :handson1-latihan:run`; ganti angka 1 dengan 2 atau 3 untuk latihan lainnya. Di Windows, gunakan `gradlew.bat` menggantikan `./gradlew`.

Jalankan server satu per satu karena ketiganya memakai port 8080. Server berhenti otomatis setelah 10 detik. Gunakan terminal lain untuk mengirim request sesuai daftar latihan di bawah.

## Daftar Latihan

### 1. `handson1-latihan` — HTTP Server Sederhana
Buat `HttpServer` yang listen di port 8080 dan merespon `GET /hello` dengan teks statis `"Hello, Kotlin Backend!"`.

- **Uji dengan:** `curl http://localhost:8080/hello`
- **Konsep:** `HttpServer.create`, `createContext`, `sendResponseHeaders`, `responseBody`.

### 2. `handson2-latihan` — Routing & JSON Sederhana
Tambahkan route `GET /users` yang mengembalikan daftar user dalam format JSON (dibangun manual, tanpa library), lengkap dengan header `Content-Type: application/json`.

- **Uji dengan:** `curl http://localhost:8080/users`
- **Konsep:** routing berbasis path, serialisasi JSON manual, HTTP response header.

### 3. `handson3-latihan` — Request Handling & Status Code
Implementasikan `POST /echo` yang membaca body request lalu mengembalikannya apa adanya, ditambah handler default yang mengembalikan status `404 Not Found` untuk path yang tidak dikenal.

- **Uji dengan:** `curl -X POST -d 'halo dunia' http://localhost:8080/echo` dan `curl -i http://localhost:8080/tidak-ada`
- **Konsep:** membaca request body, kode status HTTP (2xx/4xx/5xx), routing fallback.
