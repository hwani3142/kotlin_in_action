package ch3_Functions

import java.util.*

fun <T> testOf(vararg values: T): ArrayList<T> = arrayListOf(*values)

fun main() {
    val lili = testOf("11", "22", "33")
    println(lili)
    for ((idx, item) in lili.withIndex()) {
        println("${idx} : ${item}")
    }
}