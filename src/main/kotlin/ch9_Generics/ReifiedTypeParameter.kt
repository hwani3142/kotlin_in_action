package ch9_Generics

fun printSum(c: Collection<Int>) {
    if (c is List<Int>)     // Can check type in compile time. It is because type parameter of 'c' is 'Int'!
        println(c.sum())
}

// reified type parameter := can know type in run-time. == do not remove actual type on type parameter during run-time
inline fun <reified T> isA(value: Any) = value is T

fun main() {
    printSum(listOf(1, 2, 3, 4))
    printSum(setOf(1, 2, 3, 4))     // print nothing

    println(isA<String>("asd"))
    println(isA<String>(123))

    println(listOf("one", 2, "three", 4L).filterIsInstance<String>())
}