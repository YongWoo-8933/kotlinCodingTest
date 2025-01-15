package com.example.kotlincodingtest

/**
백준 11779 최소비용 구하기 2 (골드3)

1. 다익스트라 알고리즘 구현
2. heapq를 통해 비용이 적은 경우부터 계산
3. check를 통해 최소 비용을 갱신할 때, (최소비용, 직전노드) 의 튜플형식으로 저장
4. check에서 도착지 최소비용을 산출하고, 직전 노드로 거슬러 올라가며 경로를 산출
*/

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt(); val m = readLine().toInt()
    val links = Array<MutableSet<IntArray>>(n+1) { mutableSetOf() }
    repeat(m) {
        val (fr, to, cost) = readLine().split(" ").map{ it.toInt() }
        links[fr].add(intArrayOf(to, cost))
    }
    val (startNode, endNode) = readLine().split(" ").map{ it.toInt() }
    val hq = PriorityQueue<IntArray> { a, b -> a[0].compareTo(b[0]) }
    hq.add(intArrayOf(0, startNode))
    val visited = Array(n+1) { intArrayOf(Int.MAX_VALUE, 0) }
    visited[startNode][0] = 0
    while(hq.isNotEmpty()) {
        val (totalCost, node) = hq.remove()
        if (node==endNode) break
        for ((nextNode, nextCost) in links[node]) {
            if (totalCost+nextCost<visited[nextNode][0]) {
                visited[nextNode] = intArrayOf(totalCost+nextCost, node)
                hq.add(intArrayOf(totalCost+nextCost, nextNode))
            }
        }
    }
    val route = mutableListOf(endNode)
    var previousNode = visited[endNode][1]
    while(previousNode>0) {
        route.add(previousNode)
        previousNode = visited[previousNode][1]
    }
    println(visited[endNode][0])
    println(route.size)
    route.reversed().forEach{ println(it) }
}