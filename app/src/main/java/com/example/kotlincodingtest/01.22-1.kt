package com.example.kotlincodingtest

/**
백준 1647 도시분할계획 (골드4)

1. 크루스칼 알고리즘을 기반으로 함
2. 최소 스패닝 트리를 구할 때, 가중치가 가장 큰 '마지막 간선을 추가하지 않는다'면
최소한의 비용으로 노드들을 두 집합으로 구분할 수 있게됨
3. 따라서 크루스칼 알고리즘을 통해 구한 유지비 합에서 마지막에 더했던 cost값을 뺀값을 출력
*/

import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map{ it.toInt() }
    val roads = arrayListOf<IntArray>()
    repeat(m) {
        roads.add(readLine().split(" ").map{ it.toInt() }.toIntArray())
    }
    roads.sortBy{ it[2] }
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

    var answer = 0
    var lastCost = 0
    for ((a, b, c) in roads) {
        if (find(a)!=find(b)) {
            union(a, b)
            answer += c
            lastCost = c
        }
    }
    print(answer-lastCost)
}