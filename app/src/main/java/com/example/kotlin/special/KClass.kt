package com.example.kotlin.special

import kotlin.reflect.KClass


interface Plugin{
    fun performAction()
}

class PluginA : Plugin{
    override fun performAction() {
        println("Plugin A is performing it's actions")
    }

}

class PluginB : Plugin{
    override fun performAction() {
        println("Plugin B is performing it's action")
    }

}


fun loadPlugin(pluginClass : KClass<out Plugin>) : Plugin{
    return pluginClass.constructors.first().call()
}




fun main(){
    val isUserRegistered = false
    val pluginToLoad : KClass<out Plugin> = if (isUserRegistered) PluginA::class else PluginB::class
    val plugin = loadPlugin(pluginToLoad)
    plugin.performAction()
}












