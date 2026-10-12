import java.util.Properties

fun main() {
    val inputStream = object {}.javaClass.classLoader.getResourceAsStream("app.properties")
        ?: error("Resource app.properties tidak ditemukan di classpath")
    val properties = Properties()
    inputStream.use { properties.load(it) }
    println("Nama aplikasi: ${properties.getProperty("app.name")}")
    println("Versi: ${properties.getProperty("app.version")}")
}
