package com.example.androidoverview.basicOfKotlin

fun main() {
    val userName = "Roma"                       // val is immutable means it will not allow to change value of its variable
    var number = 1                              // it is mutable means it allow user to change  initial value of variable
    println ("Hello $userName")
    println(number)
    number = 25
    println(number)
}
