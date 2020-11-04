package ch7_OperatorOverloading

class PersonWithDynamicProperties {
    private val _attributes = hashMapOf<String, String>()
    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String by _attributes
    val company: String by _attributes
}

fun main() {
    val p = PersonWithDynamicProperties()
    val data = mapOf("name" to "JH", "company" to "TmaxTibero")
    for ((attrName, value) in data) {
        p.setAttribute(attrName, value)
    }
    println(p.name)
    println(p.company)
}