open class Animal(val name: String)
class Cat(name: String) : Animal(name)

// Container hanya mengeluarkan T, jadi covariance aman di sini.
interface Container<out T> {
    fun get(): T
}

class CatContainer(private val cat: Cat) : Container<Cat> {
    override fun get(): Cat = cat
}

fun printAnimalName(container: Container<Animal>) {
    println("Nama hewan: ${container.get().name}")
}

fun main() {
    val catContainer: Container<Cat> = CatContainer(Cat("Oyen"))
    printAnimalName(catContainer)
}
