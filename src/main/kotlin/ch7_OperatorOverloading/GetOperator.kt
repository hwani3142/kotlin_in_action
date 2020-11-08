package ch7_OperatorOverloading

data class Point(val x: Int, val y: Int)

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid index")
    }
}

operator fun Point.get(idx1: Int, idx2: Int): Int {
    if (idx1 == 0)
        return this[1]
    else
        return this[0]
}

fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    println(p1[1])
    println(p1[1, 1])

}