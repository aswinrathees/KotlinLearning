open class Inheritance constructor(var name: String, var age: Int) {

    open fun printValue(name: String, age: Int) {
        println("Name $name  ")
    }
}

class InheritedChild(name: String, age: Int, gender: String) : Inheritance(name, age) {
    var userGender: String = ""

    init {
        userGender = gender
    }

//    override fun printValue(name: String, age: Int) {
//        println("Overrided Name : $name Age : $age Gender : $userGender")
//    }

    fun printAllValue() {
        println("Name : $name Age : $age Gender : $userGender")
    }
}

fun main() {
    val inheritedChild = InheritedChild("Aswin", 29, "Male")
    inheritedChild.printValue("Aswin",29)
    inheritedChild.printAllValue()
}