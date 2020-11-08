package ch3_Functions

import java.util.*

data class Student(val id: Int, val name: String)

infix fun Student.elderThan(other: Student) = Pair(this.name, other.name)

fun main() {
    val st12 = Student(2012001, "DY")
    val st13 = Student(2013001, "JH")
    val (p1, p2) = st12 elderThan st13
    println("${p1} > ${p2}")

    val bin = TreeMap<Char, Int>()

    for (c in 'A'..'F') {
        bin[c] = c.toInt()
    }
    for ((key, value) in bin) {
        println("${key}:${value}")
    }

    val list = arrayListOf<String>("1", "2", "3")
    for ( (idx, item) in list.withIndex()) {
        println("[${idx}] = ${item}")
    }

}