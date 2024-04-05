package com.week3.scenario09

import kotlin.reflect.KClass


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

    var adders: MutableMap<KClass<*>, (Tool, List<Tool>) -> List<Tool>> = mutableMapOf()
        private set

    fun registerAdder(toolType: KClass<*>, adder: (Tool, List<Tool>) -> List<Tool>) {
        adders[toolType] = adder
    }

    fun add(tool : Tool){
    }


}

fun main() {
    val toolbox: ToolBox = ToolBox()

    toolbox.registerAdder(Saw::class){tool, tools ->
        println("Calling saw adder")
        tools + tool
    }
    toolbox.registerAdder(ScrewDriver::class){tool, tools ->
        println("Calling saw adder")
        tools + tool
    }

    println("Adding Tools")


    //Note  - calls to String() on each tool
    //When you print an object using println(objectName),
    // the toString method is implicitly called to display a human-readable
    // representation of the object's state


}