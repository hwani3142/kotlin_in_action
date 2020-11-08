package ch5_Lambdas

// Return instance, directly
fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done!") }  // SAM constructor for return
}

fun main() {
    // Store instance into variable
    val case1 = createAllDoneRunnable()
    case1.run()
}
