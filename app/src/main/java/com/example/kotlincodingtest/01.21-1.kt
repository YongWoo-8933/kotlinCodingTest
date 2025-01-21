package com.example.kotlincodingtest

/**
백준 1806 부분합 (골드4)

1. 두포인터 알고리즘으로 idx 관리
2. s값보다 큰 부분합이 발견되면 길이 갱신
*/

import kotlin.math.*

fun main() {
    val (n, s) = readln().split(" ").map{ it.toInt() }
    val arr = readln().split(" ").map{ it.toInt() }.toIntArray()
    var currentSum = 0
    var startIdx = 0
    var minLength = Int.MAX_VALUE
    for(endIdx in 0 until n) {
        currentSum += arr[endIdx]
        while(currentSum>=s) {
            minLength = min(minLength, endIdx-startIdx+1)
            currentSum -= arr[startIdx]
            startIdx += 1
        }
    }
    println(if(minLength!=Int.MAX_VALUE) minLength else 0)
}