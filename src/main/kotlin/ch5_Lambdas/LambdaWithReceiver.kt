package ch5_Lambdas

// with() := function that can apply to Any
//          param1 : receiver object
//          param2 : lambda
fun alphabet(): String {
    return with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nI know the alphabet!")
        toString()
    }
}

// apply() := extensions that can return receiver object
//          param1 : lambda
//          return : receiver object
fun alphabet2() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nI also know the alphabet!")
}

fun main() {
    println(alphabet())
    val alphabetSB = alphabet2()
    println(alphabetSB.toString())
}
