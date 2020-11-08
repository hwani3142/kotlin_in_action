package ch4_Classes

object CollectionManager {
    val ints = DelegatingCollection<Int>()

    fun sumAll(): Int {
        var sum = 0;
        for (value in ints) {
            sum += value
        }
        return sum
    }
}