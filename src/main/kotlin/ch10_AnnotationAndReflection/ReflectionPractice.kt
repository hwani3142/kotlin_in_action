package ch10_AnnotationAndReflection

import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

class Person(val name: String, val age: Int) {
    fun emptyFunction() {
        println("Is Empty!")
    }
}

data class Person2(val name2: String, val age2: Int)

val person = Person("Alice", 29)
val kClass = person.javaClass.kotlin
val kClass2 = Person::class // Is same as kClass?
fun tof(x: String): Int {
    return 1
}

fun main() {
    println(kClass is KClass<Person>)
    println(kClass2 is KClass<Person>)
    println(kClass.qualifiedName)
    println(kClass2.qualifiedName)
    kClass.memberProperties.forEach {
        println(it.name)
    }
    val people = listOf(Person("JH", 11), Person2("JH2", 22))
    for (p: Any in people) {
        println(p::class)
        println(p::class.members)
        println(p.javaClass.kotlin)
        println(p.javaClass.kotlin.members)
        println(p.javaClass.kotlin.constructors)
    }
    val tofVal = ::tof  // KFunction type
    println(tofVal.javaClass.name)
    println(tofVal.call("aaa"))     // Call method1
    println(tofVal.invoke("aaa"))       // Call method2
    println(tofVal("aaa"))              // Call method3
//    println(tofVal is Person2)
    println(tofVal is KFunction<Int>)
    val memberProperty = Person::age
    println(memberProperty is KProperty1<Person, Int>)
}