package ch3_Functions

data class People(val age: Int, val name: String)

fun People.isAdult(): Boolean = age > 19

data class Person(var age: Int = 5) {
    var name: String
        get() = name
        set(value) {
            name = value
        }
}

fun Person.getAge() = this.age

fun String.lastChar(): Char = get(length - 1)

fun main() {
    val p1 = People(22, "aa")
    val p2 = People(19, "Bb")
    println(p1.isAdult())
    println(p2.isAdult())

    val lastCharacter = "Extensions".lastChar()
    println("${lastCharacter}")

    val strings = listOf("first", "second", "third")
    println(strings.last())
}