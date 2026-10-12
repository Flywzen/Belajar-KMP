import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaField

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Required

data class RegistrasiForm(
    @Required val nama: String,
    @Required val email: String,
    val alamat: String?
)

fun validate(obj: Any): List<String> {
    val gagal = mutableListOf<String>()
    for (property in obj::class.memberProperties) {
        // Target anotasinya FIELD, jadi cek backing field lewat javaField.
        if (property.javaField?.getAnnotation(Required::class.java) != null) {
            val nilai = property.getter.call(obj)
            if (nilai == null || (nilai is String && nilai.isBlank())) {
                gagal.add(property.name)
            }
        }
    }
    return gagal
}

fun main() {
    val formValid = RegistrasiForm("Siti", "siti@mail.com", null)
    println("Form valid -> gagal: ${validate(formValid)}")
    val formInvalid = RegistrasiForm("", "budi@mail.com", "Jl. Merdeka")
    println("Form invalid -> gagal: ${validate(formInvalid)}")
}
