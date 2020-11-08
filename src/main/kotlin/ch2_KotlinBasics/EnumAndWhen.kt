package ch2_KotlinBasics

import ch2_KotlinBasics.ColorWithRGB.*

enum class Color {
    RED, GREEN, BLUE
}

enum class ColorWithRGB(val r: Int, val g: Int, val b: Int) {
    ORANGE(255, 165, 0), YELLOW(255, 255, 0), INDIGO(75, 0, 130), VIOLET(238, 130, 238),
    RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255);  // Require semicolon! for distinguish list and functions

    fun rgb() = (r * 256 + g) * 256 + b
}
fun getWarmth1(color: ColorWithRGB) = when(color) {
    RED, ORANGE, YELLOW -> "warm"
    else -> "cold"
}
fun getWarmth2(color: ColorWithRGB) = when(color) {
    RED, ORANGE, YELLOW -> "warm"
    GREEN -> "neutral"
    BLUE, INDIGO, VIOLET -> "cold"
}

/* **Smart Cast** */
interface Expr
class Num(val Value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval1(e: Expr): Int {
    if (e is Num)       // Smart casting to class num
        return e.Value
    else if (e is Sum)  // Smart casting to class Sum
        return eval1(e.right) + eval1(e.left)
    else
        throw IllegalArgumentException("Unknown expression")
}
fun eval2(e: Expr): Int = when (e) {
    is Num ->
        e.Value
    is Sum ->
        eval2(e.right) + eval2(e.left)
    else ->
        throw IllegalArgumentException("Unknown expression")
}

fun main() {
    println(BLUE.rgb())
    println(getWarmth1(GREEN))
    println(getWarmth2(GREEN))

    println(eval1(Sum(Sum(Num(1), Num(2)), Num(4))))

    val x = 1
    when (x) {
        1 -> println("x == 1")
        2, 3 -> println("x == 2 or x == 3")
        in 4..7 -> println("x between 4 and 7")
        !in 8..10 -> println("x not between 8 and 10")
        else -> {
            println("No")
        }
    }
    val isEvenVal = when (x % 2) {
        0 -> "짝"
        else -> "홀"
    }
    fun isEvenFun(num: Int) = when (num % 2) {
        0 -> "Even"
        else -> "odd"
    }
}