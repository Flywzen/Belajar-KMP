fun prosesDenganList(data: List<Int>): List<Int> =
    data.filter { it % 2 == 0 }.map { it * it }.take(5)

fun prosesDenganSequence(data: List<Int>): List<Int> =
    data.asSequence().filter { it % 2 == 0 }.map { it * it }.take(5).toList()

fun main() {
    val data = (1..1_000_000).toList()
    val startList = System.currentTimeMillis()
    val hasilList = prosesDenganList(data)
    val waktuList = System.currentTimeMillis() - startList
    println("List  : $hasilList (${waktuList}ms)")
    val startSeq = System.currentTimeMillis()
    val hasilSequence = prosesDenganSequence(data)
    val waktuSequence = System.currentTimeMillis() - startSeq
    println("Sequence: $hasilSequence (${waktuSequence}ms)")
    // Sekali ukur belum jadi benchmark. Sequence di sini berhenti setelah 5 hasil.
    // List sempat menghitung kuadrat besar yang overflow Int, tapi dibuang oleh take(5).
}
