package com.example.androidoverview.basicOfKotlin

fun main() {

    println("Enter FirstNumber: ")
    val firstNumber =  readLine()!!.toInt()
    println("Enter SecondNumber: ")
    val secondNumber = readLine()!!.toInt()
    println("Enter ThirdNumber: ")
    val thirdNumber =  readLine()!!.toInt()
    firstNumber?. let {
        println(firstNumber)
    } ?: {
        println("Null")
    }

    when {
        firstNumber >= secondNumber && firstNumber >= thirdNumber -> println("$firstNumber is the largest number.")
        secondNumber >= firstNumber && secondNumber >= thirdNumber -> println("$secondNumber is the largest number.")
        else -> println("$thirdNumber is the largest among three")
    }
}