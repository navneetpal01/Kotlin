package com.week3.scenario02

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
    val saw : Tool= Saw()
    val saw2 : Tool= Saw()
    val screwDriver : Tool = ScrewDriver()
    val screwDriver2 : ScrewDriver = ScrewDriver()
    println("Adding Saw..........")
    toolbox.add(saw)
    println("Adding ScrewDriver..........")
    toolbox.add(screwDriver)  // what is called?
          //compile Time signature : Toolbox.add(Tool)
    println("Adding ScrewDriver 2..........")
    toolbox.add(screwDriver2)  // what is called?
          //compile Time signature : Toolbox.add(add)
    println("Adding Saw 2..........")
    toolbox.add(saw2)   // what is called?
          //compile Time signature : Toolbox.add(Tool)


    println(toolbox.tools)

    println(Tool())


     //Note  - calls to String() on each tool
    //When you print an object using println(objectName),
    // the toString method is implicitly called to display a human-readable
    // representation of the object's state


}