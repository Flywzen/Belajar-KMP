import kotlin.reflect.full.memberProperties

data class Mahasiswa(val nim: String, val nama: String, val ipk: Double)

fun printFields(obj: Any) {
    obj::class.memberProperties.forEach { property ->
        println("${property.name} = ${property.getter.call(obj)}")
    }
}

fun main() {
    val mhs = Mahasiswa("122140000", "Budi Santoso", 3.75)
    printFields(mhs)
}
