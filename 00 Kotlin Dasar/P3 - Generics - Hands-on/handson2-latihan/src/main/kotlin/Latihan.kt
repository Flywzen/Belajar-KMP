fun <T : Comparable<T>> findMax(items: List<T>): T {
    require(items.isNotEmpty()) { "List tidak boleh kosong" }
    var terbesar = items.first()
    for (item in items.drop(1)) {
        if (item.compareTo(terbesar) > 0) terbesar = item
    }
    return terbesar
}

fun main() {
    println(findMax(listOf(3, 7, 2, 9, 4)))
    println(findMax(listOf(1.5, 2.8, 0.3)))
    println(findMax(listOf("apel", "jeruk", "duku")))
}
