package ch4_Classes

open class SecondaryConstructor<T> {
    constructor(a : T) {
        println("1 arg '${a}' constructor")
    }
    constructor(a : T, b : T) {
        println("2 args '${a}', '${b}' constructor")
    }
}

fun main() {
    val a = SecondaryConstructor<Any>(1, "abc")
    val b = SecondaryConstructor(3333)
}