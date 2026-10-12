fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int = operation(a, b)

fun main() {
    val tambah = calculate(10, 4) { x, y -> x + y }
    val kurang = calculate(10, 4) { x, y -> x - y }
    val kali = calculate(10, 4) { x, y -> x * y }
    println("Tambah: $tambah")
    println("Kurang: $kurang")
    println("Kali: $kali")
}
