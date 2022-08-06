class GenericsExample<T>(data :T) {
    var gData: T = data

    fun printValue() {
        println("Value is $gData")
    }
}

fun <T> printData(data:T) {
    println("Print $data")
}

fun main() {
    val genericsExample : GenericsExample<Int> = GenericsExample(20)
    genericsExample.printValue()
    val genericsExampleTwo : GenericsExample<String> = GenericsExample("Aswin")
    genericsExampleTwo.printValue()
    printData<Int>(29)
    printData<String>("Aswin")
}