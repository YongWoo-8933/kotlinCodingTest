package com.example.kotlincodingtest.file0214

/**
 * 백준 3976 역습 (실버2)
 *
 * 1. 조건에 맞게 하드코딩하면 됨
*/
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val answer = StringBuilder()
    repeat(readLine().toInt()) {
        val (n, l1, l2, s1, s2) = readLine().split(" ").map{ it.toInt() }
        val passDifficultyLevel1 = readLine().split(" ").map{ it.toInt() }.toTypedArray()
        val dribbleDifficultyLevel1 = readLine().split(" ").map{ it.toInt() }.toTypedArray()
        val passDifficultyLevel2 = readLine().split(" ").map{ it.toInt() }.toTypedArray()
        val dribbleDifficultyLevel2 = readLine().split(" ").map{ it.toInt() }.toTypedArray()
        var pFirst = l1; var pSecond = l2
        for(node in 0..n-2) {
            val temp1 = pFirst; val temp2 = pSecond
            pFirst = min(temp1+dribbleDifficultyLevel1[node], temp2+passDifficultyLevel2[node])
            pSecond = min(temp2+dribbleDifficultyLevel2[node], temp1+passDifficultyLevel1[node])
        }
        answer.appendLine(min(pFirst+s1, pSecond+s2))
    }
    print(answer)
}