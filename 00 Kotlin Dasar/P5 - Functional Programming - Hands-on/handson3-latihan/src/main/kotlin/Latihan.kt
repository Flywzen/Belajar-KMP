fun makeCounter(): () -> Int {
    var count = 0
    return { ++count }
}

fun main() {
    val counterA = makeCounter()
    val counterB = makeCounter()
    println(counterA())
    println(counterA())
    println(counterA())
    // Counter B punya state sendiri, tidak ikut nebeng A.
    println(counterB())
    println(counterB())
}
