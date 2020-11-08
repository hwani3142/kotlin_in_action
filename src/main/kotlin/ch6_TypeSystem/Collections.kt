package ch6_TypeSystem

fun main() {
    var i: Int = 1
    var list = listOf(1L,2L,3L)
    println(i.toLong() in list)

    var a = 1_000
    var b = 1000
    println("$a , $b")

    var list2 = listOf(1, null, 2, 3, 4)
    println(list2)
    var list2FilteredNull = list2.filterNotNull();
    println(list2FilteredNull)

    var list3 : MutableList<Int?> = list2 as MutableList<Int?>  // downcase (unstable)
    println(list2.equals(list3))
    println(list2 == list3)

    val list4 : MutableList<Int?> = mutableListOf(1,null, 2, 3, 4)
    var list5 : List<Int?> = list4  // upcast. reference is same
    println(list4.equals(list5))
    list4.add(55)
    println(list5)
}