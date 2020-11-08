package ch5_Lambdas

fun main() {
    val letters = Array<String>(26) {i -> ('a' + i).toString()}
    val filteredLetter = letters.map{ i -> i+1} // to list!!!
    val filteredLetterAsArray = filteredLetter.toTypedArray()
    filteredLetter.forEachIndexed{ index, element ->
        println("$index -> $element")
    }
}