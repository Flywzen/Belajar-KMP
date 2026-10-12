# Belajar KMP

Repo latihan dan tugas Pengembangan Aplikasi Mobile.

## Kotlin Dasar

[00 Kotlin Dasar](00%20Kotlin%20Dasar/README.md) berisi 39 latihan individu (P1–P13) yang sudah diimplementasikan. Seluruh 13 proyek berhasil dibuild; 9 test P9 lulus. Setiap topik dilengkapi wrapper Gradle 8.7 dan panduan menjalankan. Detail ada di [hasil verifikasi](00%20Kotlin%20Dasar/VERIFIKASI.md).

Latihan KMP dalam `02 Hands-on` sumber kelas adalah paket berbeda. Di repo ini yang sudah masuk baru P2–P4 pada folder `hands-on`; P1 dan P5–P10 masih perlu dilengkapi.

## Tugas mingguan

Folder `pekan-1`, `pekan-2`, `pekan-3`, dan `pekan-4` mempertahankan isi dari repo yang diunggah. Proyek pekan 3 berada di `pekan-3/pekan-3`.

## Hands-on

| Folder | Isi | Cara buka |
| --- | --- | --- |
| `hands-on` | Proyek awal yang sudah ada | Buka folder `hands-on` |
| `hands-on/handson-pekan-2` | Coroutines, Flow operators, StateFlow counter | Buka folder proyek, jalankan `main()` pada tiap modul latihan |
| `hands-on/handson-pekan-3` | Profile card, login form, daftar produk | Buka folder proyek, jalankan `composeApp` |
| `hands-on/handson-pekan-4` | Counter, form state hoisting, Todo MVVM | Buka folder proyek, jalankan `androidApp` |

Setiap folder adalah proyek Gradle terpisah. Membuka `hands-on` saja tidak otomatis menggabungkan proyek pekan 2–4 ke Gradle proyek awal.

P2 dan P3 mengikuti konfigurasi paket hands-on yang digabungkan. Keduanya belum menyertakan wrapper Gradle. P4 mempertahankan konfigurasi Android/iOS dan wrapper dari repo semula. Detail tiap proyek ada di README masing-masing.

Data contoh P2/P3 sudah memakai gaya lebih santai. Nama fungsi dan konsep latihan dipertahankan.
