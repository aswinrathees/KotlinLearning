fun main() {
    var integerArray: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val range: IntRange = 1..20
    val reverseRange: IntProgression = 20 downTo 1
    val stepProgression:IntProgression = 0..10 step 2
    val untilProgression:IntProgression = 1 until 10
    val mixProgression:IntProgression = 5 downTo 1 step 2

    for (item in range) {
        println("Item $item")
    }

    for (item in reverseRange) {
        println("Reverse Item $item")
    }

    for (item in stepProgression) {
        println("Step Item $item")
    }

    for (item in untilProgression) {
        println("Until Item $item")
    }

    for (item in mixProgression) {
        println("Mix Item $item")
    }
}