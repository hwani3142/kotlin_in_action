package ch8_HighOrderFunction

class Person (val name:String, val age:Int) : Comparable<Person> {
    operator fun plus(p:Person): Person {
        return Person(this.name + p.name, this.age + p.age)
    }

    override fun compareTo(other: Person): Int {
        return this.age - other.age
    }
}
fun printPeople(p1: Person, p2:Person,
                printFunc : (Person, Person) -> Unit ) {
    printFunc(p1, p2)
}

fun main(args:Array<String>) {
    val printName = { p1: Person, p2:Person -> println("${p1.name}, ${p2.name}")}
    val printAge = { p1: Person, p2:Person -> println("${p1.age}, ${p2.age}")}

    val p1 = Person("abc", 11)
    val p2 = Person("def", 9)
    val p3 = p1 + p2
    println("${p3.name} : ${p3.age}")
    println(p1 < p2)

    printPeople(p1, p2, printName)
    printPeople(p1, p2, printAge)
}
