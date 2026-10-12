# P3 — Compose Multiplatform Basics

Tiga latihan sudah diisi dan bisa dipilih dari menu aplikasi:

- `Handson1ProfileCard.kt`: avatar bulat, nama bold, bio abu-abu, dan Card dengan elevation. Profil contoh memakai nama Rafly.
- `Handson2LoginForm.kt`: username, password tersamar, dan tombol yang memanggil `onLogin(username, password)`. Callback pada layar contoh masih kosong; ini latihan form, belum autentikasi ke server.
- `Handson3ProductList.kt`: daftar produk dengan Card, Row, Column, dan kotak warna sebagai pengganti foto. Notebook Death Note dan kaos Akatsuki hanya data katalog contoh.

## Menjalankan

1. Buka folder ini di Android Studio sebagai proyek terpisah, lalu tunggu Gradle sync.
2. Untuk Android, jalankan modul `composeApp` pada emulator atau perangkat.
3. Untuk desktop, task yang dipakai adalah `:composeApp:run`.

Paket ini belum menyertakan Gradle wrapper (`gradlew`). Untuk task terminal, gunakan instalasi Gradle yang kompatibel atau buat wrapper terlebih dahulu. Android membutuhkan SDK sesuai konfigurasi proyek.

Source set iOS tersedia, tetapi proyek Xcode `iosApp` belum disertakan. Menjalankan iOS membutuhkan Mac, Xcode, dan host app iOS.

Nama fungsi, package, struktur latihan, dan logika utama tetap dipertahankan. Komentar difokuskan ke alasan teknis, sementara unsur pop culture cukup di data contoh.
