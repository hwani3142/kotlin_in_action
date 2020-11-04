package ch7_OperatorOverloading

fun main() {
    val a: ClosedRange<Int> = 1..2
    a.contains(1)
    println(a.start)
    println(a.endInclusive)
    val a2 = 1.rangeTo(3)   // IntRange <- IntProgression
    val a3: IntProgression = IntProgression.fromClosedRange(1, 3, 2)
    if (1 in a2) {  // contains
        println(true)
    }
    if (2 in a2) {
        println("also true!")
    }
    a2.forEach { x ->
        println("Seek ${x}!")
    }
    for (b in a3) { // iterator() ==> IntProgressionIterator
        println("step: ${a3.step}")
        println(b)
    }
}