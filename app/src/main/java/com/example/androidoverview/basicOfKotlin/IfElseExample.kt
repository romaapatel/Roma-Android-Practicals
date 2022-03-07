package com.example.androidoverview.basicOfKotlin

fun main() {
    val firstNumber = 20
    val secondNumber = 50
    val thirdNumber = 40

    if (firstNumber >= secondNumber && firstNumber >= thirdNumber)
        println("$firstNumber is the largest number.")

    else if (secondNumber >= firstNumber && secondNumber >= thirdNumber)
        println("$secondNumber is the largest number.")

    else
        println("$thirdNumber is the largest number.")

    val namesArray = arrayOf("Java","Kotlin","Python","C","C++")                    //Example of Array
    var initialIndex = 0

    while (initialIndex < namesArray.size) {
        println(namesArray[initialIndex])
        initialIndex++
    }
}