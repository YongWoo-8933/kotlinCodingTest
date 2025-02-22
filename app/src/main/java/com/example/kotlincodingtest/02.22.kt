package com.example.kotlincodingtest.file0222

/**
 * 백준 3976 역습 (실버2)
 *
 * 1. 조건에 맞게 하드코딩하면 됨
*/

fun main() = with(System.`in`.bufferedReader()) {
    readLine()
    val n = readLine().toInt()
    var maxArea = 0; var maxNum = 0
    val dp = Array(n+1){ intArrayOf(0, 0, 0, 0, 0) }
    repeat(n) {
        val (ai, ri, ci) = readLine().split(" ").map{ it.toInt() }
        if (dp[ai][0]==0) {
            dp[ai] = intArrayOf(1, ri, ri, ci, ci)
            if (maxArea==0 || (maxArea==1 && maxNum>ai)) {
                maxArea = 1
                maxNum = ai
            }
        } else {
            val (_, rm, rM, cm, cM) = dp[ai]
            if (ri<rm) dp[ai][1] = ri
            if (rM<ri) dp[ai][2] = ri
            if (ci<cm) dp[ai][3] = ci
            if (cM<ci) dp[ai][4] = ci
            val area = (dp[ai][2]-dp[ai][1]+1)*(dp[ai][4]-dp[ai][3]+1)
            dp[ai][0] = area
            if (maxArea<area || (maxArea==area && maxNum>ai)) {
                maxArea = area
                maxNum = ai
            }
        }
    }
    print("$maxNum $maxArea")
}