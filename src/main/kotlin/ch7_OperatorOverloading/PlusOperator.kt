package ch7_OperatorOverloading

fun main(args: Array<String>) {
// Not be defined to immutable list
//val list0 = listOf(1, 2)
//list0 += 3
    val list1 = arrayListOf(1, 2)
    list1 += 3
    val list2 = mutableListOf(1, 2)
    list2 += 3
}