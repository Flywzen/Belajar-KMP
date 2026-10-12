import com.sun.net.httpserver.HttpServer
import com.sun.net.httpserver.HttpExchange
import java.net.InetSocketAddress

private fun HttpExchange.respond(status: Int, body: ByteArray, contentType: String = "text/plain; charset=utf-8") {
    responseHeaders.set("Content-Type", contentType)
    sendResponseHeaders(status, if (body.isEmpty()) -1 else body.size.toLong())
    responseBody.use { it.write(body) }
    close()
}

fun main() {
    val server = HttpServer.create(InetSocketAddress("0.0.0.0", 8080), 0)
    server.createContext("/hello") { exchange ->
        when {
            exchange.requestURI.path != "/hello" ->
                exchange.respond(404, "Not Found: ${exchange.requestURI.path}".toByteArray())
            exchange.requestMethod != "GET" -> {
                exchange.responseHeaders.set("Allow", "GET")
                exchange.respond(405, ByteArray(0))
            }
            else -> exchange.respond(200, "Hello, Kotlin Backend!".toByteArray())
        }
    }
    server.start()
    println("Server berjalan di http://localhost:8080/hello")
    try {
        Thread.sleep(10_000)
    } finally {
        server.stop(0)
        println("Server dihentikan")
    }
}
