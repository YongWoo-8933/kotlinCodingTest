package com.example.kotlincodingtest

/**
백준 2166 다각형의 면적 (골드5)

1. 신발끈공식(외적을 활용한 도형넓이 구하기) 그냥 적용
*/

import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val points = arrayListOf<IntArray>()
    repeat(n) {
        val (x, y) = readLine().split(" ").map{ it.toInt() }
        points.add(intArrayOf(x, y))
    }
    var v = 0
    for (i in 0 until n-1) {
        v += points[i][0]*points[i+1][1]-points[i+1][0]*points[i][1]
    }
    v += points[n-1][0]*points[0][1]-points[0][0]*points[n-1][1]
    print(String.format("%.1f", 0.5*abs(v)))
}