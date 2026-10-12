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
    server.createContext("/echo") { exchange ->
        if (exchange.requestURI.path != "/echo") {
            exchange.respond(404, "Not Found: ${exchange.requestURI.path}".toByteArray())
            return@createContext
        }
        if (exchange.requestMethod != "POST") {
            exchange.responseHeaders.set("Allow", "POST")
            exchange.sendResponseHeaders(405, -1)
            exchange.close()
            return@createContext
        }
        val requestBytes = exchange.requestBody.use { it.readBytes() }
        exchange.respond(200, requestBytes, "application/octet-stream")
    }
    server.createContext("/") { exchange ->
        exchange.respond(404, "Not Found: ${exchange.requestURI.path}".toByteArray())
    }
    server.start()
    println("Server berjalan di http://localhost:8080")
    println("Coba: curl -X POST -d 'halo dunia' http://localhost:8080/echo")
    println("Coba: curl -i http://localhost:8080/tidak-ada")
    try {
        Thread.sleep(10_000)
    } finally {
        server.stop(0)
        println("Server dihentikan")
    }
}
