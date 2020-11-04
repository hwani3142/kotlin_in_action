package ch7_OperatorOverloading

fun loadEmails(p: Person): List<String> {
    println("Person: Load emails once")
    return listOf<String>("a", "b", "c")
}
class Person(val name: String) {  // NOTE: inner class!
    val emails by lazy { loadEmails(this) }
}

class Person2(val name: String) {
    private fun loadEmails(): List<String> {
        println("Person2: Load emails once")
        return listOf<String>("a", "b", "c")
    }

    val emails by lazy { loadEmails() }
}

fun main() {
    val p2 = Person2("DG")
    println(p2.emails)
    println(p2.emails)
}