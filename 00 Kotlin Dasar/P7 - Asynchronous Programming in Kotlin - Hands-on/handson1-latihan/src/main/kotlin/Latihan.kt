import kotlinx.coroutines.*

suspend fun checkOrderStatus(orderId: String): String {
    delay(2000)
    return "Order $orderId: SHIPPED"
}

fun main() = runBlocking {
    println("Menunggu status pesanan...")
    println(checkOrderStatus("A100"))
    // delay menangguhkan coroutine. runBlocking tetap menahan thread pemanggil
    // sampai blok selesai; dipakai sebagai jembatan main biasa ke suspend fun.
}
