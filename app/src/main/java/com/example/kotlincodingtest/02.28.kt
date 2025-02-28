package com.example.kotlincodingtest.file0228

/**
 * 백준 13702 이상한 술집 (실버2)
 *
 * 1. 단순 구현
*/

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map{ it.toInt() }
    val arr = Array(n){ readLine().toLong() }
    var lp = 1L; var rp = arr.maxOf{ it }
    while(lp<=rp) {
        var num = 0L
        val cp = (lp+rp)/2
        for(v in arr) {
            num += v/cp
            if (num>=k) break
        }
        if(num>=k) {
            lp = cp+1
        } else {
            rp = cp-1
        }
    }
    print(rp)
}