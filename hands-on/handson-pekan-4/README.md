# Hands-on P4 — State dan MVVM

Menu di `App.kt` berisi tiga latihan:

1. Counter: tambah, kurang (nonaktif di 0), reset.
2. Form dengan state hoisting: `LabeledTextField` stateless dipakai untuk Name dan Email.
3. Todo MVVM: `TodoViewModel` dengan `StateFlow`, tambah todo, abaikan input kosong, toggle selesai.

## Menjalankan
Buka folder ini di Android Studio, sync, jalankan `androidApp`.
Lewat terminal: `./gradlew :androidApp:assembleDebug` (Windows: `gradlew.bat :androidApp:assembleDebug`).
iOS lewat `iosApp` di Xcode.
