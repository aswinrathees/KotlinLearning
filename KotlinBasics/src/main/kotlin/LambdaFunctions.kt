fun main() {
    var counter:Int = 0
    val sum:(Int,Int) -> Int = {
        a:Int,b:Int ->
        counter++
        a+b
    }

    println("Lambda sum:${sum(10,20)}")
    println("Counter value: $counter")
}