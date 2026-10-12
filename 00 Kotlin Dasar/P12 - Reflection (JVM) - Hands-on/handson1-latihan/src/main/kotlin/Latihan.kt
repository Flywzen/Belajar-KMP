import kotlin.reflect.full.memberProperties

data class Product(val nama: String, val harga: Int)

fun main() {
    val product = Product("Kopi Susu", 18000)
    val kelas = product::class
    println("Kelas: ${kelas.simpleName}")
    println("Properties:")
    kelas.memberProperties.forEach { println("- ${it.name}") }
}
