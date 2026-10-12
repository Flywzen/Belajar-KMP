fun factorialBiasa(n: Long, acc: Long = 1): Long {
    if (n <= 1) return acc
    return factorialBiasa(n - 1, acc * n)
}

tailrec fun factorialTailrec(n: Long, acc: Long = 1): Long {
    if (n <= 1) return acc
    return factorialTailrec(n - 1, acc * n)
}

fun main() {
    println("factorialBiasa(20) = ${factorialBiasa(20)}")
    println("factorialTailrec(20) = ${factorialTailrec(20)}")
    try {
        println("factorialBiasa(100000) = ${factorialBiasa(100000)}")
    } catch (e: StackOverflowError) {
        println("factorialBiasa(100000) -> StackOverflowError! (dibatasi ukuran stack JVM)")
    }
    println("factorialTailrec(100000) = ${factorialTailrec(100000)} (tidak overflow stack)")
    // Stack aman, kapasitas Long tetap terbatas. Hasil n besar bukan faktorial akurat.
}
