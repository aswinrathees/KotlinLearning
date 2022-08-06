//class ParameterizedConstructor constructor(var name:String,var age:Int) {
class ParameterizedConstructor constructor(var name: String = "Aswin", var age: Int = 29) {
    //class ParameterizedConstructor constructor(name:String,age:Int) {
    var userName: String = ""
    var userAge: Int = 0
    var userGender: String = ""

    init {
        userName = name
        userAge = age

    }

    constructor(name: String, age: Int, gender: String) : this(name, age) {
        userGender = gender
    }
}

fun main() {
//    val user = ParameterizedConstructor("Aswin",29)
//    val user = ParameterizedConstructor()
    val user = ParameterizedConstructor("Aswin", 29, "Male")
    println("Details are ${user.userName} and ${user.userAge} and ${user.userGender}")
}