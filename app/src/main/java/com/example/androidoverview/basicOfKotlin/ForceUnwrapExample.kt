package com.example.androidoverview.basicOfKotlin

val colors: String? = null

fun main() {
    val greeting = "Hello"
    println(greeting)

    val name: String? = "null"
    val nameLength = name!!.length
    println(nameLength)

    val num: Int? = null
    num!!.div(10)
    println(num)

    if (colors != null) {
        println("Welcome")
          println(colors)
    } else {
        println("String is null")
        //print(colors?.length)
    }
}
