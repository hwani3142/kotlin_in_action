package ch4_Classes

sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun sealedEval(e: Expr): Int =
    when (e) {
        is Expr.Num -> e.value
        is Expr.Sum -> sealedEval(e.left) + sealedEval(e.right)
        // NOTE: sealed does not require else branch, because sealed notify the existance of nested class to compiler
    }

fun main() {

}