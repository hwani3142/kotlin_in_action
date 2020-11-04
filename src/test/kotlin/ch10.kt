import junit.framework.Assert.assertEquals
import org.junit.Test

const val TEST_TIMEOUT = 1000L

class TestWrapper { // Required at least one wrapper class
    @Test
    fun KtTest() {
        assertEquals(1, 1)
    }

    //    val TEST_TIMEOUT = 1000L    // Cannot read in compile time
    @Test(timeout = TEST_TIMEOUT)
    fun AnnotationParameterForProperty(list: List<*>) {

        @Suppress("UNCHECKED_CAST")
        val strings = list as List<String>
    }
}
