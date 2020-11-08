package ch2_KotlinBasics

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader) : Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}
fun readNumberByExpression(reader: BufferedReader){
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    } finally {
        reader.close()
    }
    println(number)
}

fun main() {
    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))
    val reader2 = BufferedReader(StringReader("932"))
    readNumberByExpression(reader2)
}