package ch9_Generics

interface TestList<T> {
    operator fun get(index: Int): T
}
class StringTestList: TestList<String> {    // Explicit Type parameter
    override fun get(index: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
class ArrayTestList<T> : TestList<T> {      // Pass type parameter also.
    override fun get(index: Int): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

// Self-reference for type parameter
class Person : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

// Generic extension property
val <T> List<T>.penultimate: T
    get() = this[size - 2]

// type parameter constraint (upper bound)
// same as T extends CharSequence, Appendable
fun <T> ensureTarilingPeriod(seq: T) where T : CharSequence, T: Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

fun main() {
    val l = listOf("a", "b", "c")
    val l2 = l.slice(1..2)
    println("${l} \n ${l2}")


    println(listOf(1, 2, 3, 4).penultimate)

    var str = "aaaa"
    var sb = StringBuilder()
    sb.append(str)
    ensureTarilingPeriod(sb)
    println(sb.toString())

}