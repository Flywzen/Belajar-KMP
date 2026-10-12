import java.lang.reflect.Modifier

class Greeter {
    companion object {
        @JvmStatic
        fun greet(name: String): String = "Halo, $name!"
    }
}

fun main() {
    println(Greeter.greet("Mahasiswa"))
    val staticMethodNames = Greeter::class.java.methods
        .filter { Modifier.isStatic(it.modifiers) }.map { it.name }
    println("Method static pada Greeter.class: $staticMethodNames")
    val punyaStaticGreet = staticMethodNames.contains("greet")
    println("Greeter.class punya static method 'greet'? $punyaStaticGreet")
    check(punyaStaticGreet) { "greet() belum jadi static method di Greeter.class" }
}
