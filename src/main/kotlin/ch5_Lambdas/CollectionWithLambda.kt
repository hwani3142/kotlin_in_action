package ch5_Lambdas

fun add(x: Int, y: Int) = x + y
// {인수1:타입1, 인수2:타입2 -> 본문}
var add2 = { x: Int, y: Int -> x + y }

data class Person(val name: String, val age: Int = 30)

fun main() {
    val people = listOf(Person("JH", 27), Person("SB", 26))
    println(people.maxBy { it.age }) // lambda 불필요한 소괄호가 모두 제거된 상태
    println(people.maxBy(Person::age)) // member reference

    val newPerson = { x: String, y: Int -> Person(x, y) }
    println(newPerson("CH", 28))
    run { println("Self call") }
    val newPerson2 = ::Person
//val pp2 = newPerson2("aaa")
    people.forEach { println(it.age) }

    fun Person.isAdult() = age > 26

    val numbers = mapOf(0 to "zero", 1 to "one", 3 to "one") // Collection map
    numbers.iterator()
    numbers.mapValues { it.value.toUpperCase() } // Functional map
    numbers.mapValues { it.key.toLong() } // Functional map

    val a: Person = people.firstOrNull { it.age == 27 }!!
}