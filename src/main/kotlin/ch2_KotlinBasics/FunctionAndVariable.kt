package ch2_KotlinBasics

fun max1(a: Int, b: Int): Int {
    return if (a > b) a else b  // 삼항연산자 대신. if는 식(expression)
}
fun max2(a: Int, b: Int) = if (a > b) a else b  // 식이 본문인 함수. Return type inference

fun greet(str: String) {
    println(str)
    println("$str") // String formatter
}

fun main() {
    println("Hello world")
    val aValue = 5  // value (immutable)
    //aValue = 10 // Error
    var a = 5       // variable (mutable)
    a = 10
    println(a + 20)

    greet("aaaa")

    // Types
    val b = 20L
    val c = 10.0
    val d = 10.0f
    val str = "asda"
    val char = 'a'
    val multi_str = """
    asdasdasdasd
    asdasdasdas
""".trimIndent()

}
