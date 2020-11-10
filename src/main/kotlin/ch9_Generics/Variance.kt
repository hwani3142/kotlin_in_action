package ch9_Generics

import kotlin.reflect.KClass

fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}
fun readAnswer(list: List<Any>) {
    println("${list}")
}
fun cannotReadAnswer(list: MutableList<Any>) {
    println("${list}")
}

// [Ref] - http://happinessoncode.com/2017/05/21/java-generic-and-variance-1/
// Covariant := A가 B의 subtype이면, List<A>는 List<B>의 subtype이다. [Producer]
class Covariance() {
    fun ProducerTest(p : Producer<Any>) {
        println(p.produce())
    }
    interface Producer<out T> {
        fun produce() : T
    }
    class prod1 : Producer<Any> {
        override fun produce(): Any {
            return "aaa"
        }
    }
    class prod2 : Producer<String> {
        override fun produce(): String {
            return "bbb"
        }
    }
    fun main() {
        val p1 = prod1()
        val p2 = prod2()
        ProducerTest(p1)
        ProducerTest(p2)
    }
}
// Contravariance
class ContraVariance() {
    val anyComparator = Comparator<Any> {
        e1, e2 -> e1.hashCode() - e2.hashCode()
    }
    fun main() {
        val strings = listOf("abc", "def", "ghi")
        strings.sortedWith(anyComparator)
    }
}

// Star projection is same as <out Any?>
// Use if it does not consider 'concrete type'
fun printFirst(list: List<*>) {
    if (list.isNotEmpty())
        println(list.first())
}

interface FieldValidator<in T> {
    fun validate(input : T): Boolean
}
object StringValidator : FieldValidator<String> {
    override fun validate(input: String): Boolean = input.isNotEmpty()
}
object IntValidator : FieldValidator<Int> {
    override fun validate(input: Int): Boolean = input >= 0
}

// Encapsulation for preventing type miss-casting
object Validators {
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T: Any> registerValidator (
        kClass: KClass<T>, fieldVaildator: FieldValidator<T> ) {
        validators[kClass] = fieldVaildator
    }
    @Suppress("UNCHECKED_CAST")
    operator fun <T: Any> get(kClass: KClass<T>) : FieldValidator<T> =
        validators[kClass] as? FieldValidator<T>
            ?: throw IllegalArgumentException("No validator for ${kClass.simpleName}")
}

fun main() {
    val strings = mutableListOf("abc", "bca")
//    addAnswer(strings)        // 추가/변경에 대해 타입 불일치가 발생할 수 있어서 불가
    readAnswer(strings)         // 읽기 전용이므로 가능
//    cannotReadAnswer(strings)   // 변경 가능 => 불가

    // subtype != subclass
    val str1: String = "aaa"
    val str2: String? = str1

    val cov = Covariance()
    cov.main()

    Validators.registerValidator(String::class, StringValidator)
    Validators.registerValidator(Int::class, IntValidator)

    println(Validators[String::class].validate("kotlin"))
    println(Validators[String::class].validate(""))
    println(Validators[Int::class].validate(42))
    println(Validators[Int::class].validate(-1))
}