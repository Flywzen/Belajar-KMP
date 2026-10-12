# Hasil verifikasi Kotlin Dasar

Diperiksa pada 12 Oktober 2026 dengan JDK 17, Kotlin 1.9.24, dan Gradle 8.7.
Sumber soal: commit `0303f3ed53b230a85836b14dccd9d01aae7a0c2b` pada repo kelas IF25-22017.

| Pemeriksaan | Hasil |
| --- | --- |
| Kelengkapan proyek | 13 topik, masing-masing 3 modul: 39 latihan |
| Build Gradle | 13 dari 13 proyek berhasil menjalankan `build` |
| Kompilasi Kotlin langsung | 39 dari 39 modul berhasil |
| Program konsol | 33 entry point dijalankan; output yang ditentukan soal diperiksa |
| P9: JUnit | 9 test lulus, 0 gagal; dijalankan lewat JUnit Console dan Gradle |
| Pemeriksaan batas/kasus khusus | 24 kelompok pemeriksaan tambahan lulus |
| P10: custom task | Nama project `handson2-latihan`, versi `1.0.0`, Gradle `8.7` |
| P10: resource dan dependency | Resource terbaca dari classpath; datetime berhasil dikompilasi dan dijalankan |
| P13: server HTTP | Ketiga server diuji dengan request nyata dan berhenti otomatis |
| Placeholder kode | Tidak ada pemanggilan TODO(), fail() starter, atau simbol placeholder tersisa |

Pemeriksaan tambahan meliputi batas grade 59/60, 69/70, 79/80, 89/90, 100/101; null dan list kosong; covariance; counter multi-thread; saldo setelah penarikan gagal; parser tiket salah format; coroutine yang dibatalkan; anotasi FIELD untuk nilai null/blank; serta escaping JSON.

P13 diuji untuk GET /hello dan GET /users (200), Content-Type JSON, POST /echo dengan byte biner dan body kosong, metode yang salah (405), path asing termasuk prefix mirip (404), dan shutdown otomatis setelah 10 detik.

## Catatan saat dijalankan ulang

- Waktu eksekusi, urutan log antarthread, urutan properti reflection, dan tanggal dapat berbeda. Itu bukan kegagalan selama perilaku yang diminta tetap benar.
- Pada P7 latihan 3, pembatalan terjadi sekitar 1200 ms: normalnya foto 1000 ms selesai, dokumen 1500 ms dan video 3000 ms dibatalkan.
- P11 tailrec menghindari stack overflow; hasil faktorial besar tetap overflow Long sesuai contoh soal.
- Unduhan awal Gradle/dependency dan port 8080 yang sudah dipakai proses lain dapat memengaruhi proses menjalankan ulang.
- Status ini khusus `00 Kotlin Dasar`. Hands-on KMP P1 dan P5–P10 masih belum ditambahkan pada paket ini; P2–P4 mempertahankan hasil merge sebelumnya.
