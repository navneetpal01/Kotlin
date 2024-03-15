package com.week3

import kotlin.math.min

//Three tenets of OO programming
//   Encapsulation
//        - hiding data
//        - protecting data
//   Inheritance
//        - creating more specific classes based on existing classes, possibly adding properties/functions
//        - Liskov substitutability

//   Polymorphism


private var amountOfPb = 32 //no control - could be a mistake anywhere in this file

fun removerPb(amount: Int): Int {
    val removed = min(amount, amountOfPb)
    //Problem - caller's responsibility
    amountOfPb -= removed
    return removed
}


// Encapsulation
class PbJar {
    var amountOfPb = 32 //control!!!
        //The default in kotlin is PUBLIC
        private set
    //get is public but can't change it


    fun removerPb(amount: Int): Int {
        val removed = min(amount, amountOfPb)
        //Problem - caller's responsibility
        amountOfPb -= removed
        return removed
    }


}


fun main() {
    //Encapsulation -  great for control
    val jar = PbJar()  //Creates instance of PbJar
    println(jar.amountOfPb)
    jar.removerPb(10)
    println(jar.amountOfPb)
    jar.removerPb(10)
    println(jar.amountOfPb)
    jar.removerPb(10)
    println(jar.amountOfPb)
    jar.removerPb(10)
    println(jar.amountOfPb)
    jar.removerPb(10)
    println(jar.amountOfPb)

}