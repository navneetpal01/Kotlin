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


fun main1() {
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


//Inheritance
//Kingdom Phylum (or Division) Class Order Family Genus Species

//Kotlin design flow - everything is final/closed by default
open class Animal {   //should be abstract - open makes it extendable
    var name: String = "Batman"
    fun run() {
        println("Running..........")
    }

    open fun bloodTempRange(): IntRange {
        return 0..100
    }
}

//when something is abstract it had to be open
// abstract - cannot create it - "concept"

abstract class Mammal : Animal() {

    override fun bloodTempRange(): IntRange {  //Polymorphism - override subclass function/properties
        return 80..100
    }

    //override and overload
    //  -overload different signatures with same name - only parameters
    //          -reducing namespace/surface area of the type
    //  -override same name and parameters
    //          -changing behaviour






}

class Cat : Mammal()

class Dog : Mammal()


fun main() {
    val animal: Animal = Cat()
    println(animal.name)
    animal.run()
    val cat: Cat = Cat()
    println(cat.name)
    cat.run()

    goAnimal(animal = Cat())
    goAnimal(animal = Dog())
//  goAnimal(animal = Mammal()) can't create abstract!!
}


fun goAnimal(animal: Animal) {
    println(animal.name)
    animal.run()
}
























