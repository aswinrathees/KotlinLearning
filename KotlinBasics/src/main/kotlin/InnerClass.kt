class InnerClass {
    var name:String = "Aswin"

    inner class ClassInner {
        fun printValue () {
            println("Hi $name")
        }
    }
}

fun main() {
    val innerClass = InnerClass()
    innerClass.ClassInner().printValue()
}