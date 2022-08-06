interface Bulb {
    fun on()
    fun off()
}

class InterfaceExample : Bulb {
    override fun on() {
        println("Bulb On")
    }

    override fun off() {
        println("Bulb Off")
    }

}

class InterfaceExampleTwo : Bulb {
    override fun on() {
        println("Bulb 2 On")
    }

    override fun off() {
        println("Bulb 2 Off")
    }

}


fun main() {
    val interfaceExample = InterfaceExample()
    interfaceExample.on()
    interfaceExample.off()

    val interfaceExampleTwo = InterfaceExampleTwo()
    interfaceExampleTwo.on()
    interfaceExampleTwo.off()
}