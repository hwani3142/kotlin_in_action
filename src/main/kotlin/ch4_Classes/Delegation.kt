package ch4_Classes

class DelegatingCollection<T>(
    val innerList: MutableCollection<T> = ArrayList<T>()
) : MutableCollection<T> by innerList {
    var addedCount = 0
    override fun add(element: T): Boolean {
        addedCount++
        return innerList.add(element)
    }

    fun getCount() = addedCount
}

fun main() {
    val ints = DelegatingCollection<Int>()
    ints.add(1)
    ints.add(2)
    ints.add(3)
    for ((index, value) in ints.withIndex()) {
        println("ints[${index}] = ${value}")
    }
    println("$ints, ${ints.getCount()}")
}