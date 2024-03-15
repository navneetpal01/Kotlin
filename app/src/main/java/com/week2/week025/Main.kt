package com.week2.week025

typealias doSomethingDoer = (Int,Int) -> Unit


fun doStuff(
    x : Int,
    y : Int,
    doSomething : (Int,Int) -> Unit,  //recommended way..............

    ){
    println("---------------------")
    println("x=$x, y=$y")
    doSomething(x,y)
    println("---------------------")

}

fun doStuff2(
    x : Int,
    y : Int,
    doSomething : doSomethingDoer,

    ){
    println("---------------------")
    println("x=$x, y=$y")
    doSomething(x,y)
    println("---------------------")

}

var z : Int = 0
fun main(){
    //what is happening here with z?
    //In Kotlin LAMBDAS ARE CLOSERS: They capture and modify their environment
    doStuff(x = 10,y = 20){ x , y ->
        println(x + y + z) //Lambda has to know about z - It's a CLOSER - doesn't use a copy of z
           // when lambda defined gets it's value when we evaluate the expression
        z = 100
        //In Java - z would be treated as "effectively final"
        //        --can not be modified after anon inner class set up that uses it
        //        --makes a copy of value of z, and won't let you modify z after

    }
    println(z)
}
