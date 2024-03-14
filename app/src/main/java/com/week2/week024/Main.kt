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

fun printStuff1(
    //This is a template method
    vararg names: String,
    getThingToPrint: (String) -> String, //This is a strategy function - also known as lambda function in Kotlin
) {
    for (name in names) { //Redundant
        println( //Redundant
            getThingToPrint(name)
        ) //Redundant
    } //Redundant

}
fun printStuff2(
    //This is a template method
    vararg names: String,
    getThingToPrint: (String) -> String, //This is a strategy function - also known as lambda function in Kotlin
    doBefore: (String) -> Unit = {}, //optional - same as {name -> //do nothing}
    doAfter: (String) -> Unit = {}, //optional - same as {name -> //do nothing}
) {
    for (name in names) { //Redundant
        doBefore(name)
        println( //Redundant
            getThingToPrint(name)
        ) //Redundant
        doAfter(name)
    } //Redundant

}

fun justPrintName(name: String) = name
fun printDoctorName(name: String) = "Dr. $name"

//In math we can compose functions:
//f(g(10))
//f(n) = f'(g(n))
//f(n , g) = g(n)

//HIGHER-ORDER FUNCTIONS
// 1- Pass functions as parameters, AND/OR
// 2- return function as result


//----------------------------------------------- strategy function == lambda function
fun main() {
    printStuff1(
        "Scott", "Marry", "Steve", "Sue",
        getThingToPrint = ::justPrintName, //Function Reference
    )
    printStuff1(
        "Scott", "Marry", "Steve", "Sue",
        getThingToPrint = ::printDoctorName, //Function Reference
    )

    //If we're only ever using the functions just print name and print doctor name once ,
    //This is a good bit extra to define , we can shorten this

    printStuff1(
        "Scott", "Marry", "Steve", "Sue",
        getThingToPrint = { name ->
            "Dr. $name"
        } //Defining a function INLINE
        // Also knows as lambda is a unnamed function
    )

    printStuff1(
        "Scott", "Marry", "Steve", "Sue",
        getThingToPrint = { name ->
            val doctorName = "Dr. $name"
            println("DEBUG : $doctorName")
            doctorName
        }
    )
    //If only we have a single argument , we don't have to specify it's name can be it
    printStuff1(
        "Scott", "Marry", "Steve", "Sue",
        getThingToPrint = {"$it is just a person"}
    )

    //If last arg is a function you can move it outside parens
    //short hand for last arg lambda
    printStuff1(
        "Scott", "Marry", "Steve", "Sue"
    ){
        "$it is just a person"
    }
    printStuff1("Scott", "Marry", "Steve", "Sue"){ "$it is just a person" }
    printStuff1("Scott", "Marry", "Steve", "Sue"){ name ->"$name is just a person" }

    //If you have more than one lambda specify them in parens as named arguments

    printStuff2(
        "Scott", "Marry", "Steve", "Sue",
        getThingToPrint = {it},
        doBefore = { print("    ") },
        doAfter = { println() },
    )

    printStuff2(
        "Scott", "Marry", "Steve", "Sue",
        getThingToPrint = {it}
    )


}
