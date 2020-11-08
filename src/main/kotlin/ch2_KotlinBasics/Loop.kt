package ch2_KotlinBasics

fun main() {
    // Arrays
    val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val number2 = arrayOf(0, 1, 2, 3, 4)
    print(number2[2])

    for (num in numbers) {
        println(num)
    }

    for (i in 1..3) {
        println(i)
    }
    for (i in 0..10 step 2) {
        println(i)
    }
    for (i in 10 downTo 0 step 2) {
        println(i)
    }
    for (i in 1..5) {
        println(i)
    }
    for (i in 5 downTo 1 step 1) {
        println(i)
    }
    for (i in 1 until 6) {
        println(i)
    }
    /*
     * while & do-while are same as JAVA
     */

}