package com.example.kotlincodingtest.file0120_2

/**
백준 9252 LCS 2 (골드4)

1. LCS알고리즘 구현
2. dp테이블을 만들고 각 구간별 LCS길이(int값) 갱신
3. 테이블을 모두 채우고 나면, 거꾸로 읽어가면서 LCS문자열 산출
*/

import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val a = readLine(); val b = readLine()
    val dp = Array(a.length+1) { Array(b.length+1) { 0 } }
    for (i in a.indices) {
        for (j in b.indices) {
            dp[i+1][j+1] = if(a[i]==b[j]) dp[i][j]+1 else max(dp[i][j+1], dp[i+1][j])
        }
    }
    println(dp[a.length][b.length])
    if (dp[a.length][b.length]>0) {
        var row = a.length; var col = b.length
        var answer = ""
        while(row>=0 && col>=0) {
            val x = dp[row][col]
            if(x==0) {
                break
            }
            when(x) {
                dp[row-1][col] -> row -= 1
                dp[row][col-1] -> col -= 1
                else -> {
                    answer += a[row-1]
                    row -= 1
                    col -= 1
                }
            }
        }
        println(answer.reversed())
    }
}