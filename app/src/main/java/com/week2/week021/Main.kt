package com.week2.week021

//Explicit
var x: Int = 20

//IMPLICIT
var y = 20

fun main() {

    //As a Expression - HAVE TO COVER ALL THE CASES
    val result1 = if (x < 10) {
        "Low"
    } else if (y < 10) {
        "Medium"
    } else {
        "whatevs"
    }
    println(result1)

    //As a statement - NOT HAVE TO COVER ALL THE CASES
    if (x < 10) {
        println("Low")
    } else if (y < 10) {
        println("Medium")
    } // else{
//        println("whatevs")
//    }

    var resultA = ""
    if (x < 10) {
        resultA = "Low"
    } else if (y < 10) {
        resultA = "Medium"
    }
    println(resultA)



    //Expression -> Not checking the same value
    val result2 = when {
        x < 10 -> "Low"
        y < 10 -> "Medium"
        x >= 10 && y >= 10 -> "High"
        else -> "whatevs"
    }

    //Statement -> Not checking the same value
    when {
        x < 10 -> println("Low")
        y < 10 -> println("Medium")
        x >= 10 && y >= 10 -> println("High")
    }

    //Checking the same value

    val result3 = when(x + y){
        20 -> "foo"
        25 -> "fee"
        30 -> "fie"
        else -> "bye" //what if we wanted to print the value?

    }
    val result4 = when(val z = x + y){
        //It is expecting to have int you can't use x < 20
        20 -> {
            println("The value was 20")
            "foo"// last expression is the value of the block
        }
        25 -> "fee"
        30 -> "fie"
        else -> "Bye : value is $z"
    }
    println(result4)



}

fun foo() {
    x = 100
}