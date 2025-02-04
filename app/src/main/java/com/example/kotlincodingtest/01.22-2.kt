package com.example.kotlincodingtest.file0122_2

/**
백준 1717 집합의 표현 (골드5)

1. 유니온 파인드 알고리즘 진행
2. find 함수에서 경로압축 반드시 할 것
*/

import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, t) = readLine().split(" ").map{ it.toInt() }
    val roots = Array(n+1) { it }

    fun find(x: Int): Int {
        if(roots[x]!=x) {
            roots[x] = find(roots[x])
        }
        return roots[x]
    }

    fun union(a: Int, b: Int) {
        val ra = find(a); val rb = find(b)
        if(ra!=rb) {
            roots[max(ra, rb)] = min(ra, rb)
        }
    }

    repeat(t) {
        val (o, a, b) = readLine().split(" ").map{ it.toInt() }
        if (o>0) {
            if(find(a)!=find(b)) {
                println("NO")
            } else {
                println("YES")
            }
        } else {
            union(a, b)
        }
    }
}