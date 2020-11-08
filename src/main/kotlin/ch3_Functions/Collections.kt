package ch3_Functions

fun main() {
    val foods = listOf("a", "b", "c")
    val mutFoods = mutableListOf("a", "b", "c")
    mutFoods.add("d")

    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    val mutMap = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
    mutMap["d"] = 4

    val set = setOf("a", "b", "c")
    val mutSet = mutableSetOf("a", "b", "c")
    mutSet.add("d")
}