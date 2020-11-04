package ch7_OperatorOverloading

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)   // 리스너 목록 관리
    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class ObservablePerson(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {
    private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue) // property 변화를 알림
    }
    var age: Int by Delegates.observable(age, observer)         // 위임
    var salary: Int by Delegates.observable(salary, observer)   // 위임
}

fun main() {
    var p = ObservablePerson("JH", 19, 19)
    p.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
        }
    )
    p.age = 26
    p.salary = 31
    println(p.age)

}
