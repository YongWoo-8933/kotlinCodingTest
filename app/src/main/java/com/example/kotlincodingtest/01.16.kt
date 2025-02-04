package com.example.kotlincodingtest.file0116

/**
백준 13172 Σ

1. 페르마 소정리 활용
2. 분할거듭제곱으로 매우 큰 지수계산 실행
*/

import kotlin.math.*

const val MOD = 1000000007L

fun powAndMod(x: Int, n: Int): Long {
    var res = x.toLong()
    repeat(n) {
        res *= res
        res %= MOD
    }
    return res
}

fun pow(x: Int, n: Int): Long {
    var res = 1L
    repeat(n) {
        res *= x
    }
    return res
}

fun gcd(a: Int, b: Int): Int {
    val r = if(a>b) a%b else b%a
    return if (r==0) b else gcd(min(a, b), r)
}

fun main() = with(System.`in`.bufferedReader()) {
    val m = readLine().toInt()
    val exponents = arrayListOf<Int>()
    var temp = MOD-2
    while (temp>0) {
        val exponent = log2(temp.toDouble()).toInt()
        exponents.add(exponent)
        temp -= pow(2, exponent)
    }
    var answer = 0L
    repeat(m) {
        var (n, s) = readLine().split(" ").map{ it.toInt() }
        var inverseN = 1L
        if(s%n!=0) {
            val q = gcd(n, s)
            n /= q; s /= q
            for(exponent in exponents) {
                inverseN *= powAndMod(n, exponent)
                inverseN %= MOD
            }
        }
        answer += (s*inverseN)%MOD
        answer %= MOD
    }
    print(answer)
}