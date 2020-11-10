@file:Description("Custom annotation")  // Target to class that contains top-level functions and properties
@file:JvmName("CustomAnnotationKt")

package ch10_AnnotationAndReflection

import com.sun.org.glassfish.gmbal.Description

@JvmOverloads
fun DefaultParamsFunc(a:String = "", b: Int = 3) {

}

class TemporaryFolder(val path: String = "")

class HasTempFolder {
    @get:Description("[use-site target] Description annotation to Getter() ")
    val folder = TemporaryFolder()
}

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class ExcludeThis

@Target(AnnotationTarget.PROPERTY)
annotation class RenameThis(val name: String)

data class AnnotatedPerson (
    @RenameThis("alias") val name: String,
    @get:ExcludeThis val age: Int? = null
)

@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class MetaAnnotation

@MetaAnnotation
annotation class NewAnnotation

