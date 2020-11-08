package ch6_TypeSystem

fun sendEmailTo(email : String) {
    println("Sending email to $email")
}

fun main() {
    val n1: String? = "zz"
    val n11: String = "zz"
    val n2: String = n11
    val n3: String? = n1
    val n4: String = n1!!

    val u1: String? = null
    var upper = u1?.toUpperCase()
    println(upper)

// 엘비스 연산자. 안전한 기본값 반환
    var upper2 = u1?.toUpperCase() ?: "초기화 값"
    println(upper2)

    var email: String? = "tester@example.com"
    email?.let { sendEmailTo(it)}
     email = null
    email?.let { sendEmailTo(it)}

    lateinit var aa : String
    //println(aa)   // Abnormal exit
    aa = "Hello"
    println(aa)

    // lazy with delegation
    val lazy_str: String by lazy {
        println("초기화")
        "lazy hello"
    }
    println(lazy_str)
    println(lazy_str)

}