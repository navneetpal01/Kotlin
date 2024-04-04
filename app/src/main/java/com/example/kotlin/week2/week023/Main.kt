package com.week2.week023

import java.lang.RuntimeException

fun main() {
    val x = a()
    println(x)
    println(a())
    println(b1())
    println(b2())
    println(d1(2, 4))
    println(d2(5, 7))
    println(e1(1, 2, true, false, 10))

    //named parameters
    println(
        e1(
            a = 1,
            b = 2,
            isList = true,
            personExists = false, z = 10
        )
    )
    println(
        f1(
            a = 1,
            b = 2,
            isList = true,
            z = 10
        )
    )

    println(
        f1(
            a = 1,
            b = 2,
        )
    )

    println(g1("A"))
    println(g1("A", "B"))
    println(g1("A", "B", "C", "D", "E", "F"))
    println(
        g4b(
            "A",
            "B",
            "C",
            "D",
            x = "X",
            y = "Y"
        )
    ) //If vararg early need to name the latter para
    //recommend to always put varargs last

}

// simple function with no parameters and return a value - ONLY ONE RETURN VALUE

fun a(): Int {
    return 10
}

// single expression function

fun b1(): Int = 10 // can explicit say that it returns a value
fun b2() = 20 // can write it Implicit

var n = 20


// single expression function

fun c1() = if (n < 10) 10 else 20 // eq to Java's ternary expression "n < 10 ? 10 : 20"

fun c2() = // eq to Java's ternary expression "n < 10 ? 10 : 20"
    if (n < 10) {
        10
    } else {
        20
    }

fun c3(): Int {
    if (n < 10) {
        return 10
    } else {
        return 20
    }
}

fun c4(): Int {
    return if (n < 10) {
        10
    } else {
        20
    }
}

fun c5(): Int {
    return if (n < 10) 10 else 20
}


// Parameters
fun d1(x: Int, y: Int): Int = x + y //single expression function - NO COMMA AFTER LAST PARAMETER

fun d2(
    x: Int,
    y: Int, //multi line parameters - always add , after last parameter
): Int = x + y //single expression function


fun e1(
    a: Int,
    b: Int,
    isList: Boolean,
    personExists: Boolean,
    z: Int,
): Int = a + b //single expression function


@JvmOverloads  //generates equiv java overload functions (same name different arg list)
fun f1(
    a: Int,
    b: Int,
    isList: Boolean = false, //Default value
    personExists: Boolean = true, //Default value
    z: Int = 10, //Default value
): Int = a + b //single expression function

fun g1(vararg items: String): String { //The vararg keyword in used to assign as many string you want to there's no limit
    var result = ""
    for (item in items) {
        result += "$item,"
    }
    return result
}

fun g1a(x: String, y: String, z: String) {
    println(x)
    println(y)
    println(z)
}

fun g2(vararg items: String): String { //The vararg keyword in used to assign as many string you want to there's no limit
//    return g1(items) //won't work type mismatch
    return g1(*items) //works - spread the arguments out - spread operator - don't know the number of items needed
    //* used for array for list into vararg
}

fun g3(vararg items: String) {
//    g1a(*items) //won't work
    g1a(items[0], items[1], items[2])
}

fun g4a(x: Int, y: Int, vararg items: String) {

}

fun g4b(vararg items: String, x: String, y: String) {

}

//If need multiple "vararg" groups - must use data structure like list or array
fun g4c(names: List<String>, addresses: List<String>, x: Int, y: Int) {

}

fun g4d(name: Array<String>) {
    g3(*name)
}

fun g4e(name: Array<String>) =
    g3(*name)
//what is the type of g4e as it;s a single expression
//Don't return anything
//Default return type in kotlin is 

fun g4f(name: List<String>) {
//    g3(*name) will not work spread only works with Array
}


fun sampleFunction1() : Unit { //You can explicitly set Unit as the return type
    //But it's never needed and you will probably never see it

}

fun sampleFunction2() : Unit { //Equivalent to sample function one
    //But it's never needed and you will probably never see it

}

//Fast fail functions
fun a(n : Int, x : Int, y : Int){
    //people typically did this as "single entry , single exit" approach
    if (n in 5..10){
        if (x in 1..10) {
            if (y in 10..100) {
                println("Do something (could be complex)")
            }
        }
    }
}

//fail-fast

fun failFastA1(n : Int, x : Int, y : Int){
    //less readable conditions
//    if (!(n in 5..10)) return
//    if (n < 5 || n > 10) return

    if (n !in 5..10) return
    if (x !in 1..10) return
    if (y !in 10..100) return
    //people typically did this as "single entry , single exit" approach
   println("do something (could be complex)")
}

fun failFastA2(n : Int, x : Int, y : Int){
    if (n !in 5..10) throw RuntimeException("n is bad")
    if (x !in 1..10) throw RuntimeException("x is bad")
    if (y !in 10..100) throw RuntimeException("y is bad")
    //people typically did this as "single entry , single exit" approacnbvh
   println("do something (could be complex)")
}

fun failFastA3(n : Int, x : Int, y : Int){
    check(n in 5..10){ "n is bad" }
    check(x in 1..10){ "n is bad" }

    //people typically did this as "single entry , single exit" approach
   println("do something (could be complex)")
}





