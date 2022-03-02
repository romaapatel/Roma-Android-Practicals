package com.example.androidoverview.basicOfKotlin

fun getUserName(name : String) {                                             //example of function
    println("hello $name")
}

class Sum {

    fun doSum() {
        val firstNumber = 10
        val secondNumber = 20
        val total = firstNumber + secondNumber
        println("Sum of two number $total")
    }
}

fun main() {
    val getSum = Sum()    //object created
    getSum.doSum()
    getUserName("Roma")
}

