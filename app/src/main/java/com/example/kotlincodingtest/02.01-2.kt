package com.example.kotlincodingtest.file0201_2

/**
백준 20040 사이클 게임 (골드4)

1. 사이클 발생 여부를 따져야하므로, union-find 알고리즘 활용
2. 전형적인 union-find 알고리즘 구현 후, 사이클이 발견되면 종료하고 몇번째인지 출력
 */

import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map{ it.toInt() }
    val roots = Array(n) { it }

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

    var answer = 0
    for(turn in 1..m) {
        val (a, b) = readLine().split(" ").map{ it.toInt() }
        if (find(a)!=find(b)) {
            union(a, b)
        } else {
            answer = turn
            break
        }
    }
    print(answer)
}