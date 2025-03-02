package com.example.kotlincodingtest.file0302

/**
 * 백준 22984 반짝반짝 2 (골드 5)
 *
 * 1. 순회하며 단순 확률계산
*/

fun main() {
    val n = readln().toInt()
    val prob = readln().split(" ").map{ it.toDouble() }
    var answer = prob.first()
    for(i in 1 until n) {
        answer += prob[i-1]+(1.0-prob[i-1])*prob[i]*2
    }
    print(answer)
}