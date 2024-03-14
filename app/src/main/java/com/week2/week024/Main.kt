package com.week2.week024


//CONCEPTS
//Template Pattern and strategy Patterns
//        Template method - algorithm with replaceable  steps
//        strategy - passing in something to replace step with


fun printNames(vararg names: String) {
    for (name in names) { //Redundant
        println( //Redundant
            name //Different
        ) //Redundant
    } //Redundant
}

fun printDoctors(vararg names: String) {
    for (name in names) { //Redundant
        println( //Redundant
            "Dr. $name" //Different
        ) //Redundant
    } //Redundant
}


// GOAL : create function that can keep all the commonality and take Another function to decide what to print

//NEED FUNCTIONAL TYPES to define parameter

fun printStuff( //This is a template method
    vararg names: String,
    getThingToPrint : (String) -> String, //This is a strategy function - also known as lambda function in Kotlin
) {
    for (name in names) { //Redundant
        println( //Redundant
            getThingToPrint(name)
        ) //Redundant
    } //Redundant

}

fun justPrintName(name : String) = name
fun printDoctorName(name : String) = "Dr. $name"

//In math we can compose functions:
//f(g(10))
//f(n) = f'(g(n))
//f(n , g) = g(n)

//HIGHER-ORDER FUNCTIONS
// 1- Pass functions as parameters, AND/OR
// 2- return function as result



fun main() {
    printStuff(
        "Scott","Marry","Steve","Sue",
        getThingToPrint = ::justPrintName,
    )
    printStuff(
        "Scott","Marry","Steve","Sue",
        getThingToPrint = ::printDoctorName,
    )
}