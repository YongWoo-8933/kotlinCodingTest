package com.example.kotlincodingtest

/**
백준 10942 팰린드롬? (골드4)

1. dp 활용
2. dp테이블은 N x N 크기로, 수열 S의 row번째 수에서 col번째 수가 팰린드롬인지 정보를 저장
3. row == col이면 당연히 1
4. row+1 == col이면 S[row] == S[col]일경우 1, 아니면 0
5. 나머지 row, col에 대해, S[row] == S[col]일경우 dp[row+1][col-1]이 1이면 1, 그 외 경우 0
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val lst = readLine().split(" ").map{ it.toInt() }.toIntArray()
    val dp = Array(n) { Array(n) { 0 } }
    repeat(n) {
        dp[it][it] = 1
    }
    repeat(n-1) {
        dp[it][it+1] = if (lst[it]==lst[it+1]) 1 else 0
    }
    for (i in 2 until n) {
        for (row in 0 until n-i) {
            val col = row+i
            dp[row][col] = if(lst[row]==lst[col]) dp[row+1][col-1] else 0
        }
    }
    val m = readLine().toInt()
    val sb = StringBuilder()
    repeat(m) {
        val (s, e) = readLine().split(" ").map{ it.toInt() }
        sb.appendLine(dp[s-1][e-1])
    }
    print(sb)
}