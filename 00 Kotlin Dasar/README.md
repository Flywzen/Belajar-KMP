# Kotlin Dasar — 39 Latihan

Implementasi 13 topik × 3 latihan dari repo perkuliahan IF25-22017. Ini bagian Kotlin/JVM; latihan Compose/KMP tetap berada di folder `hands-on` pada repo utama.

## Cara pakai

1. Buka satu folder topik sebagai proyek Gradle terpisah di Android Studio atau IntelliJ IDEA.
2. Pilih JDK 17, tunggu sinkronisasi dependency selesai.
3. Jalankan `./gradlew :handson1-latihan:run` (Windows: `gradlew.bat :handson1-latihan:run`). Ganti nomor modul untuk latihan 2 atau 3.
4. Khusus P9: `./gradlew test`. Khusus P10 latihan 2: `./gradlew :handson2-latihan:printProjectInfo`.
5. Khusus P13, jalankan server satu per satu; masing-masing memakai port 8080 dan berhenti setelah 10 detik.

Build: Kotlin 1.9.24 dan Gradle 8.7. Unduhan dependency pertama membutuhkan internet.

## Isi

| Topik | Latihan |
| --- | --- |
| P1 Introduction | Profil nullable, when nilai, skor dan range ganjil |
| P2 OOP | Kendaraan, gaji pegawai, sealed network state |
| P3 Generics | Box.map, findMax, covariance |
| P4 Collections | Filter produk, total transaksi, List vs Sequence |
| P5 Functional | Higher-order function, function reference, closure |
| P6 Parallel | Counter thread-safe, thread pool, producer-consumer |
| P7 Asynchronous | Suspend function, launch/async, cancellation |
| P8 Exceptions | Pembagian aman, custom exception, parser tiket |
| P9 Testing | Calculator, BankAccount, TodoList: total 9 test |
| P10 Build Systems | Resource, custom Gradle task, dependency datetime |
| P11 JVM | Reified, tailrec, JvmStatic |
| P12 Reflection | Inspeksi kelas, baca properti, validator Required |
| P13 Backend | GET /hello, GET /users, POST /echo dan 404 |

Semua modul `-solusi` yang tidak tersedia sudah dikeluarkan dari settings Gradle. Modul latihan tetap menggunakan nama fungsi/class yang diminta soal, kecuali perubahan signature yang memang diminta (misalnya generic findMax).

[Hasil verifikasi](VERIFIKASI.md) • [Sumber soal dan slide](https://github.com/informatika-itera/IF25-22017-Pengembangan-Aplikasi-Mobile/tree/main/00%20Kotlin%20Dasar)

Jalankan dan telusuri sendiri alur kodenya sebelum dipakai untuk pemeriksaan individu. Catatan teknis ditaruh dekat bagian yang perlu diperhatikan, bukan di setiap baris.
