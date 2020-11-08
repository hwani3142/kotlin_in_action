package ch2_KotlinBasics

// Default: not open
open class Animal

class Dog : Animal() {  // Call constructor of base

}

open class AnimalwithName(var name: String)

class DogwithName(name2: String) : AnimalwithName(name2)

// Custom property
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        //    get() { // Custom property getter
//        return height == width
//    }
        get() = height == width
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
    var bb = B()
}