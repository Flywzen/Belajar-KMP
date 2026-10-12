# Hands-on Pekan 4 — State dan MVVM

Buka folder ini di Android Studio, sync Gradle, lalu jalankan `androidApp`. iOS tetap memakai host app di `iosApp` melalui Xcode pada Mac.

Menu `App.kt` menyediakan tiga latihan:

1. Counter dengan tombol tambah, kurang, dan reset. Kurang nonaktif saat nilai 0.
2. Form state hoisting dari repo semula. `LabeledTextField` dan `RegistrationForm` dipindahkan ke `RegistrationForm.kt`; field email, layout, dan preview data dipertahankan.
3. Todo MVVM dengan ViewModel dan StateFlow: tambah tugas, abaikan input kosong, dan toggle selesai.

Package, NIM, host Android/iOS, wrapper, serta versi toolchain mengikuti proyek semula. Dependency coroutines ditambahkan karena Todo memakai StateFlow secara langsung.

Todo belum memakai penyimpanan permanen. ID berbasis ukuran list berlaku untuk fitur tambah dan toggle yang tersedia di latihan ini.

Build Android: `./gradlew :androidApp:assembleDebug` (Windows: `gradlew.bat :androidApp:assembleDebug`).
