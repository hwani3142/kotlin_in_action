package ch2_KotlinBasics;

class Person(var nn: String) {
    //    constructor(name: String) {
//        println(name)
//    }
    var a = 1 // public
    private val b = 2 // in file
    protected val c = 3 // be inherited by parent
    internal var d = 4 // between modules

    inner class innerClass {
        fun something() {
            a = 3 // 접근 가능
            this@Person.d = 11;
            println("Has reference to outer class")
        }
    }
    class nestedClass {
        fun something() {
            // Inaccessible to member
//            a = 11;
            println("Cannot access to property")
        }
    }
}
// Default: not open
open class Animal {

}
class Dog : Animal() {  // Call constructor of base

}

open class AnimalwithName(var name: String) {

}
class DogwithName(name2: String) : AnimalwithName(name2) {

}

abstract class A {
    abstract fun func1()

    fun func2() {
        println("Do something")
    }
}
class B : A() {
    override fun func1() {  // Require override keyword
        println("Called fun1")
    }
}
interface Runnable {
    fun run()

    fun fastRun() = println("Fast run!") // Same as 'default' method in JAVA
}
class Human : Runnable {
    override fun run() {
        println("Implement run")
    }
}

fun main() {
    var p = Person("asd")
    println(p.nn)
    p.a = 2
    println(p.a)
    var p2 = Person("qwe")
    println(p2.a)

//var a = A()
    var bb = B()

}