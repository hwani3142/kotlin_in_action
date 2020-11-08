package ch4_Classes

open class View {
    open fun click() = println("View clicked")
}

open class Button : View() {
    override fun click() = println("Button clicked")
}

class ChildButton : Button() {
    override fun click() = println("Child button clicked")
}

// Static decision
fun View.showOff() = println("I'm a view!")

fun Button.showOff() = println("I'm a button!")
fun ChildButton.showOff() = println("I'm a child-button!")

fun main() {
    val view: View = ChildButton()
    view.click()
    view.showOff()
    val bt: ChildButton = view as ChildButton
    bt.showOff()
    bt.click()
}
