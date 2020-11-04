package ch10_AnnotationAndReflection

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class ExcludeThis

@Target(AnnotationTarget.PROPERTY)
annotation class RenameThis(val name: String)

