# Hands-on Pertemuan 9 (Kotlin Dasar) — Testing

Implementasi latihan ada di tiga modul `handson1-latihan` sampai `handson3-latihan`. Deskripsi soal asli disimpan di [SOAL.md](SOAL.md); status pemeriksaan ada di [VERIFIKASI.md](../VERIFIKASI.md).

## Menjalankan

Buka folder ini sebagai proyek Gradle terpisah di IntelliJ IDEA atau Android Studio. Gunakan JDK 17.

Jalankan `./gradlew test` (Windows: `gradlew.bat test`). Tiga modul berisi total 9 test JUnit.

## Daftar Latihan

### 1. `handson1-latihan` — Unit Test Dasar (Pola AAA)
Lengkapi test untuk class `Calculator` (`add`, `subtract`, `divide`) mengikuti pola **Arrange-Act-Assert**, menggunakan `assertEquals(expected, actual)`.

- **Konsep:** `@Test`, `@DisplayName`, `assertEquals`, pola AAA.

### 2. `handson2-latihan` — Testing Exception
Lengkapi test untuk class `BankAccount`. Fokus pada kasus `withdraw()` yang harus melempar `InsufficientFundsException` saat saldo tidak cukup.

- **Konsep:** `assertThrows<T> { ... }`, custom exception, exception testing.

### 3. `handson3-latihan` — Test Lifecycle & Setup
Lengkapi `@BeforeEach` pada `TodoListTest` supaya setiap test mendapat instance `TodoList` baru yang kosong, lalu lengkapi test `add`/`remove`/`isEmpty`.

- **Konsep:** `@BeforeEach`, test isolation/fixture setup.
