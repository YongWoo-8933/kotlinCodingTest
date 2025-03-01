package com.example.kotlincodingtest.file0301

/**
 * 백준 2002 추월 (실버1)
 *
 * 1. 단순 구현
*/

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val inCars = Array(n){ readLine().trim() }.reversed().toMutableList()
    val outCars = Array(n){ readLine().trim() }.reversed().toMutableList()
    val overTakers = mutableSetOf<String>()
    var inCar = inCars.removeLast()
    var outCar = outCars.removeLast()
    while(inCars.isNotEmpty() && outCars.isNotEmpty()) {
        when (inCar) {
            outCar -> {
                inCar = inCars.removeLast()
                outCar = outCars.removeLast()
            }
            in overTakers -> {
                inCar = inCars.removeLast()
            }
            else -> {
                overTakers.add(outCar)
                outCar = outCars.removeLast()
            }
        }
    }
    print(overTakers.size)
}