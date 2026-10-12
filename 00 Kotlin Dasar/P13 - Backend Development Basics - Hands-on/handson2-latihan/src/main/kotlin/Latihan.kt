import com.sun.net.httpserver.HttpServer
import com.sun.net.httpserver.HttpExchange
import java.net.InetSocketAddress

private fun HttpExchange.respond(status: Int, body: ByteArray, contentType: String = "text/plain; charset=utf-8") {
    responseHeaders.set("Content-Type", contentType)
    sendResponseHeaders(status, if (body.isEmpty()) -1 else body.size.toLong())
    responseBody.use { it.write(body) }
    close()
}

data class User(val id: Int, val name: String)

val users = listOf(User(1, "Andi"), User(2, "Budi"), User(3, "Citra"))

// Tetap JSON manual sesuai soal; quote dan karakter kontrol perlu di-escape.
private fun escapeJson(value: String): String = buildString {
    for (c in value) {
        when (c.code) {
            34, 92 -> { // Double quote atau backslash.
                append(92.toChar())
                append(c)
            }
            in 0..31 -> {
                append(92.toChar())
                append('u')
                append(c.code.toString(16).padStart(4, '0'))
            }
            else -> append(c)
        }
    }
}

fun usersToJson(users: List<User>): String = users.joinToString(prefix = "[", postfix = "]", separator = ",") {
    """{"id":${it.id},"name":"${escapeJson(it.name)}"}"""
}

fun main() {
    val server = HttpServer.create(InetSocketAddress("0.0.0.0", 8080), 0)
    server.createContext("/users") { exchange ->
        when {
            exchange.requestURI.path != "/users" ->
                exchange.respond(404, "Not Found: ${exchange.requestURI.path}".toByteArray())
            exchange.requestMethod != "GET" -> {
                exchange.responseHeaders.set("Allow", "GET")
                exchange.respond(405, ByteArray(0))
            }
            else -> exchange.respond(200, usersToJson(users).toByteArray(), "application/json")
        }
    }
    server.start()
    println("Server berjalan di http://localhost:8080/users")
    try {
        Thread.sleep(10_000)
    } finally {
        server.stop(0)
        println("Server dihentikan")
    }
}
