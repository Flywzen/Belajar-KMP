import kotlinx.coroutines.*

// Hands-on 1: Coroutines Dasar
// Tugas: Ambil data dari 2 sumber secara PARALEL menggunakan async/await,
// lalu tampilkan hasilnya. Target sekitar 1000 ms; sequential sekitar 1800 ms.

suspend fun fetchUserProfile(userId: String): String {
    delay(1000) // Simulasi network delay
    return "User: Rafly"
}

suspend fun fetchUserPosts(userId: String): List<String> {
    delay(800) // Simulasi network delay
    return listOf("Benerin bug", "Muncul bug baru", "Balik ke bug pertama")
}

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()

    // Mulai dua request sebelum await, supaya tidak saling menunggu.
    val profileDeferred = async { fetchUserProfile("123") }
    val postsDeferred = async { fetchUserPosts("123") }

    // Ambil hasil setelah kedua request dimulai.
    val profile = profileDeferred.await()
    val posts = postsDeferred.await()

    println(profile)
    println("Posts: $posts")

    // Kedua delay berjalan bersamaan; totalnya sekitar 1 detik.
    val endTime = System.currentTimeMillis()
    println("Waktu: ${endTime - startTime}ms")
}
