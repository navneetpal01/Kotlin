package com.week1.week011



var redundantProperty : Int = 10
    get() {   //Default Getter
        return field   //Just a place where 10 got stored
    }
    set(value){   //Default Setter
        field = value
    }

val SimpleGetterProperty1 : Int //No Backing Field
    get() {
        return 10
    }

//------------------------------------------------
val SimpleGetterProperty2 : Int //No Backing Field
    get() { //Read only, not immutable might not be idempotent
        return getValue()
    }
fun getValue() : Int {
    return behindTheScenes
}
var behindTheScenes : Int = 10
//Difference between read only and immutable
//SimpleGetterProperty2 = 20 // Can not it's read only
//------------------------------------------------

//TODO How it look at Default
//These two are actually same
var name : String = ""
var nameToLog : String = ""
    get() {
        println("reading nameToLog")
        return field
    }
    set(value) {
        println("writing nameToLog")
        field = value
    }

//TODO DataBase Example
var nameInDataBase : String
    get() {
        return "Value from DataBase" //Pretend there was a call from the DataBase
    }
    set(value) {
        //Store value in DataBase
        println("Value Stored in the DataBase  $value")
    }


open class Mammal
class Cat : Mammal()
class Dog : Mammal()
//This function is run inside the class in JavaVm the default name of the class is same as the file name
fun main(){

    nameInDataBase = "Raw"
    println(nameInDataBase)

    println(nameToLog)
    nameToLog = "Scot"
    println(nameToLog)



    var x : Int = 42  //Property Declaration - CAN WRITE
    x = 10
    println(x)

    val  y : Int = 15 //Property Declaration - CANNOT WRITE
//   y = 100 CANNOT DO THIS!!
    println(y)

    var z  = 300 //Kotlin can Infer that Z is an Int based on the value

    var mammal1 = Cat() //type of "mammal" is Cat
    var mammal2 : Mammal = Cat() //type od "mammal2" is Mammal
    mammal2 = Dog()

    //Don't work
//    mammal1 = Dog()


    println("Hello, world")
}