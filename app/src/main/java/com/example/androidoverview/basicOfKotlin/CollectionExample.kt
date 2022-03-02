package com.example.androidoverview.basicOfKotlin

fun main() {
    val nameList = listOf("Roma", "Prarthana" , "Katha")
    println(nameList[0])
    println(nameList[2])

    for (name in nameList) {
        println(name)
    }

    for (initialValue in 1 until 6) {
        println(initialValue)
    }
}
