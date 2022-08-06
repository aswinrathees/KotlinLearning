fun max(a: Int, b: Int): Int {
    val maxValue = if (a > b) {
        a
    } else if (a == b) {
        a
    } else {
        b
    }
    return maxValue
}

fun printNumber(a: Int) {
    when (a) {
        0 -> println("Number is 0")
        1 -> println("Number is 1")
        else -> {
            println("Number is something else")
        }
    }
}

fun checkRange(a: Int) {
    when(a) {
        isNegative(a) -> println("is the given value ")
        in(-100..-1) -> println("Less than 0")
        in(0..10) -> println("In range 0-10")
        in(11.. 100) -> println("In range 0-100")
        else -> {
            println("Greater than 100 or less than -100")
        }
    }
}

fun isNegative(a: Int) : Int{
    if(a < -100 ) {
        print("Less than -100")
    }
    return a
}

fun main(array: Array<String>) {
    println("Max value among 10 and 7 is ${max(10, 7)}")
    printNumber(11)
    checkRange(-1100)
}