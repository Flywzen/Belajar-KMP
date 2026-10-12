inline fun <reified T> isType(value: Any): Boolean = value is T

fun main() {
    println(isType<String>("Hello"))
    println(isType<Int>("Hello"))
    println(isType<String>(123))
}

// Generic biasa kehilangan informasi T saat runtime karena type erasure.
// inline + reified membuat tipe konkret tersedia di lokasi pemanggilan,
// sehingga compiler bisa menghasilkan pemeriksaan is untuk tipe tersebut.
// Ini tidak memulihkan parameter elemen List<String> dari objek List saat runtime.
