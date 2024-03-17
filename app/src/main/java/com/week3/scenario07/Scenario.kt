package com.week3.scenario07

//In Kotlin if you aren't defining anything so by default it's Any 
open class Tool : Any() {
    var name: String = ""
    override fun toString(): String {
        return this::class.simpleName!!  //almost never use "!!"

    }

}

class ScrewDriver : Tool()

class Saw : Tool()


open class ToolBox {
    var tools = emptyList<Tool>()
        //protected set
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

    open fun add(tool: Saw) {   //C
        println("      Toolbox.add(Saw)")
        tools += tool

    }

}

class SafeToolBox : ToolBox() {

    override fun add(tool: Saw) {   //D
        println("      Toolbox.add(Saw) - adding safely!!")
        super.add(tool)
    }
}


fun main() {
    val safetoolbox: SafeToolBox = SafeToolBox()
    val tools = listOf(Saw(), ScrewDriver())

    println("Adding Tools")

    safetoolbox.add(Saw())  //what will be called?? - add(Saw)
    println(safetoolbox.tools)


    //Note  - calls to String() on each tool
    //When you print an object using println(objectName),
    // the toString method is implicitly called to display a human-readable
    // representation of the object's state


}