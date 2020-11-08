package ch4_Classes

/* Access modifier */
//internal open class TalkativeButton {
//    private fun yell() = println("Hey!")
//    protected fun whisper() = println("Let's talk!")
//}
// fun TalkativeButton.giveSpeech() {
//    yell()
//    whisper()
//}

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
            this@Person.d = 11
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

fun main() {
    var p = Person("asd")
    println(p.nn)
    p.a = 2
    println(p.a)
    var p2 = Person("qwe")
    println(p2.a)
}