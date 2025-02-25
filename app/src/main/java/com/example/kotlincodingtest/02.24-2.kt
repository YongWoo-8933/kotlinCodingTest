package com.example.kotlincodingtest.file0224_2

/**
 * 백준 21600 계단 (실버1)
 *
 * 1. dp로 이전 노드에서 만들 수 있는 최대 계단수를 갱신해나가면 됨.
*/
import kotlin.math.*

fun main() {
    readln()
    var dp = 0
    var answer = 1
    for(height in readln().split(" ").map{ it.toInt() }) {
        dp = min(height, dp+1)
        answer = max(answer, dp)
    }
    print(answer)
}