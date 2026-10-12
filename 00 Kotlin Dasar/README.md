# Kotlin Dasar — 39 Latihan

13 topik × 3 latihan (Kotlin/JVM biasa). Latihan KMP/Compose ada di folder `hands-on`.

## Cara menjalankan

1. Buka satu folder topik sebagai proyek Gradle terpisah, gunakan JDK 17, tunggu sync selesai.
2. Jalankan `./gradlew :handson1-latihan:run` (Windows: `gradlew.bat :handson1-latihan:run`). Ganti angka 1 jadi 2 atau 3 untuk latihan lain.
3. P9: `./gradlew test`. P10 latihan 2: `./gradlew :handson2-latihan:printProjectInfo`.
4. P13: jalankan server satu per satu, port 8080, berhenti otomatis setelah 10 detik.

Kotlin 1.9.24, Gradle 8.7. Sync pertama butuh internet.

## Daftar

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
| P9 Testing | Calculator, BankAccount, TodoList (9 test) |
| P10 Build Systems | Resource, custom Gradle task, dependency datetime |
| P11 JVM | Reified, tailrec, JvmStatic |
| P12 Reflection | Inspeksi kelas, baca properti, validator Required |
| P13 Backend | GET /hello, GET /users, POST /echo dan 404 |

Soal dan slide asli: [repo kelas](https://github.com/informatika-itera/IF25-22017-Pengembangan-Aplikasi-Mobile/tree/main/00%20Kotlin%20Dasar).
