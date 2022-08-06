fun main() {
    fun printName(name: String): Unit {
        println("Name is $name")
    }

    printName("Aswin Rathees")
    printAge(29)

    // Default
    printData("Aswin Rathees")
    //Named arguments
    //    printData("Aswin Rathees", age = 28)
    printAllData("Aswin","Mini","Rathees")
}

fun printAge(age: Int) {
    println("Age is $age")
}

fun printData(name: String, age: Int = 29) {
    println("Name is $name and age is $age")
}

fun printAllData(vararg names: String) {
    for (name in names) {
        println("Name $name")
    }
}