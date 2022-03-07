package com.example.androidoverview.basicOfKotlin

fun main() {
    val stringDisplay: String? = null
    stringDisplay?.let { println(it) }
    println("Enter name")
    val name = readLine()
    name?.let { println(it) }
}
