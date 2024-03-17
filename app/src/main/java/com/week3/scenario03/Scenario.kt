package com.week3.scenario03

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


    //These two are the overloads
    fun add(tool: Tool) {  //A
        println("      Toolbox.add(Tool)")
        tools += tool

    }
    fun add(tool: ScrewDriver) {   //B
        println("      Toolbox.add(ScrewDriver)")
        tools += tool

    }

}

fun main() {
    val toolbox = ToolBox()
    val tools = listOf(Saw(),ScrewDriver())

    println("Adding Tools")

    for (tool in tools){
        toolbox.add(tool) // what is called here
               //compile time signature is Toolbox.add(Tool)
    }

    println(toolbox.tools)


     //Note  - calls to String() on each tool
    //When you print an object using println(objectName),
    // the toString method is implicitly called to display a human-readable
    // representation of the object's state


}