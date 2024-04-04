package com.week1.week014



    var x = 10
    var y = 20
fun main(){
    println(x + y)

    val done = false
    val isPerson = true
    val result1a = done && isPerson  //SHORT CIRCUITING AND
    val result1b = done and isPerson // NON-SHORT-CIRCUITING AND
             //Might be useful if side effect is necessary
    val result2a = done || isPerson // SHORT-CIRCUITING OR
    val result2b = done or isPerson // NON-SHORT-CIRCUITING OR

    val xAndYAreEqual : Boolean = (x == y)
    val xAndYAreNotEqual : Boolean = (x != y)

    var n = 10
    val m1 = n++ //DO NOT DO THIS - DON'T USE n++ as a expression
        //m1 == 10,n == 11
    val m2 = ++n //DO NOT DO THIS - DON'T USE ++n as a expression
        //m2 == 11,n == 10

    n++ //Use it like a statement
    ++n //Use it like a statement
    val m3 = n //m3 == 14

    foo(n++) //Don't do this
    //Insted
    foo(n) //Don't do this
    n++

    n += 2

}

fun foo(n : Int){}







