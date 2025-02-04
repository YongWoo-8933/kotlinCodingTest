package com.example.kotlincodingtest.file0120_2

/**
백준 1197 최소 스패닝 트리 (골드4)

- 크루스칼 알고리즘: 모든 간선을 가중치 오름차순으로 정렬 후,
유니온 파인드 알고리즘을 통해 사이클이 생기지 않도록
간선을 추가하며 MST를 찾아냄.
*/

import kotlin.math.*


fun main() = with(System.`in`.bufferedReader()) {
    val (v, e) = readLine().split(" ").map{ it.toInt() }
    val links = mutableListOf<IntArray>()
    repeat(e) {
        val (fr, to, weight) = readLine().split(" ").map{ it.toInt() }
        links.add(intArrayOf(fr, to, weight))
    }
    links.sortBy { it[2] }
    val roots = Array(v+1){ it }

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
    for ((a, b, w) in links) {
        if(find(a)!=find(b)) {
            answer += w
            union(a, b)
        }
    }
    println(answer)
}