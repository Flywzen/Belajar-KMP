# Hands-on Pertemuan 12 (Kotlin Dasar) — Reflection (JVM)

Implementasi latihan ada di tiga modul `handson1-latihan` sampai `handson3-latihan`. Deskripsi soal asli disimpan di [SOAL.md](SOAL.md); status pemeriksaan ada di [VERIFIKASI.md](../VERIFIKASI.md).

## Menjalankan

Buka folder ini sebagai proyek Gradle terpisah di IntelliJ IDEA atau Android Studio. Gunakan JDK 17.

Jalankan `./gradlew :handson1-latihan:run`; ganti angka 1 dengan 2 atau 3 untuk latihan lainnya. Di Windows, gunakan `gradlew.bat` menggantikan `./gradlew`.

## Daftar Latihan

### 1. `handson1-latihan` — Inspeksi Kelas dengan KClass
Gunakan `product::class` untuk mendapatkan `KClass<Product>`, lalu cetak nama kelas dan daftar nama seluruh property-nya lewat `memberProperties`.

- **Konsep:** `KClass`, `::class`, `memberProperties`.

### 2. `handson2-latihan` — Baca Nilai Property Dinamis
Buat fungsi generik `printFields(obj: Any)` yang mencetak semua nama dan nilai property objek apapun (mirip `toString()` otomatis) menggunakan `property.getter.call(obj)`, tanpa hardcode nama field.

- **Konsep:** `memberProperties`, `KProperty.getter`, generic reflection.

### 3. `handson3-latihan` — Custom Annotation + Reflection Validator
Buat `annotation class Required`, lalu `fun validate(obj: Any): List<String>` yang secara reflectively mengecek semua property beranotasi `@Required` tidak null/blank, dan mengembalikan daftar nama field yang gagal validasi.

- **Konsep:** custom `annotation class`, `@Target`, `@Retention(RUNTIME)`, `javaField`, validasi generik ala framework (Spring-style).

## Catatan

Anotasi Required ditargetkan ke FIELD, jadi pemeriksaan memakai javaField, bukan findAnnotation pada properti Kotlin.
