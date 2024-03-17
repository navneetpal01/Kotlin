package com.week3.scenario05

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

}

class SafeToolBox : ToolBox() {

//    var image = 3
    fun add(tool: Saw) {   //C
        println("      SafeToolBox.add(Saw) - adding safely!!")
        super.add(tool)

    }
}


fun main() {
    val safetoolbox : ToolBox = SafeToolBox()
    val tools = listOf(Saw(), ScrewDriver())
//    safetoolbox.image can't get it

    println("Adding Tools")

    safetoolbox.add(Saw())  //what will be called??
    println(safetoolbox.tools)


    //Note  - calls to String() on each tool
    //When you print an object using println(objectName),
    // the toString method is implicitly called to display a human-readable
    // representation of the object's state


}