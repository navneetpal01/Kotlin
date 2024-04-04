package com.week1.week013;


const val name = "Scott" //Stored and managed by the compiler in the class file
fun main(args: Array<String>) {
    val name1 : String= "Scott"  //String is redundant
    val name2  = "Scott"  //Prefer way

    val first = "Hello"
    val last = "World"
    val helloWorld = first + ", " + last //Basic string concatenation

    println(helloWorld)

    val helloWorldUsingTemplate1 = "$first, $last" //Basic string concatenation with template
    val helloWorldUsingTemplate2 = "${first.substring(0,2)}, ${last.substring(0,2)}" //Basic string concatenation with template

    val typeOfStrings = "animal"
    val numberOfThings = 10
    val onlyOne = 1
    println(helloWorldUsingTemplate2)

    val message1 = "There are $numberOfThings ${typeOfStrings}s"
    println(message1)
    val message2 = "There is $onlyOne $typeOfStrings"
    println(message2)


    //RAW STRINGS
    val message3 = """
        Copyright 2024 Scott Stanchfield
        All Rights Reserved
        
        Some other licence text here
    """.trimIndent()
    println(message3)


    val message4 = """
        |Copyright 2024 Scott Stanchfield
        |                         All Rights Reserved
        |
        |Some other licence text here
    """.trimMargin(marginPrefix = "|")
    println(message4)

//Takes the least indent and trims that
    val message5 = """
           Copyright 2024 Scott Stanchfield
               All Rights Reserved
        
         Some other licence text here
    """.trimIndent()
    println(message5)
}
