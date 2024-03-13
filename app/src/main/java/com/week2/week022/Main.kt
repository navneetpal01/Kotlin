package com.week2.week022

fun main() {
    val x = 10
    val y = 20
    var z = x + y

    z = x + 10
    z += 10 //same as z = z + 10, / + - * %

    val list = listOf("A", "B", "C")

    for (item in list) {
        println(item)
    }

    val range = list.indices //Gives the range from 0.... so on
    val defineRange = 1..10 // Range or indices

    for (n in list.indices) {
        println(list[n])
    }

    println("-------------------------")
    //Count till 10
    for (n in 0..10) {
        println(n)
    }
    //Count till 9
    for (n in 0 until 10) {
        println(n)
    }
    println("-------------------------")
    //will skip 2 like 0 , 2 , 4 , 6 , 8 , 10
    for (n in 0..10 step 2) {
        println(n)
    }

    //will skip 2 and the last
    for (n in 0 until 10 step 2) {
        println(n)
    }


}