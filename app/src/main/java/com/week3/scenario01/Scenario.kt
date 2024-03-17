package com.week3.scenario01

//In Kotlin if you aren't defining anything so by default it's Any
open class Tool : Any(){
    var name: String = ""
    override fun toString(): String {
        return this::class.simpleName!!  //almost never use "!!"

    }

}

class ScrewDriver : Tool()

class Saw : Tool()


class ToolBox {
    var tools = emptyList<Tool>()
        private set

    fun add(tool: Tool) {
        println("      Toolbox.add(Tool)")
        tools += tool

    }

}

fun main() {
    val toolbox = ToolBox()
    val saw = Saw()
    val screwDriver = ScrewDriver()
    println("Adding Saw..........")
    toolbox.add(saw)
    println("Adding ScrewDriver..........")
    toolbox.add(screwDriver)

    println(toolbox.tools)

    println(Tool())


     //Note  - calls to String() on each tool
    //When you print an object using println(objectName),
    // the toString method is implicitly called to display a human-readable
    // representation of the object's state


}