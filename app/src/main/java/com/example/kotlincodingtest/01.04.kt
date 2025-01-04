package com.example.kotlincodingtest

/**
백준 14938 서강그라운드 (골드4)

1. BFS를 통한 완전탐색
2. 간선 정보를 통해 연결관계를 정의하는 리스트 links 작성
3. 각 노드를 시작점으로 하는 BFS 구현
4. check 리스트에서 각 노드로 통하는 최소 거리를 갱신하며 경우 탐색
5. 방문한 노드는 모두 set에 추가하고, 마지막에 방문한 노드의 아이템값의 합을 산출
*/

fun main() = with(System.`in`.bufferedReader())  {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }
    val items = arrayListOf(0)
    items.addAll(readLine().split(" ").map{ it.toInt() })
    val links = Array(n+1) { mutableSetOf<IntArray>() }
    repeat(r) {
        val (fr, to, dist) = readLine().split(" ").map { it.toInt() }
        links[fr].add(intArrayOf(to, dist))
        links[to].add(intArrayOf(fr, dist))
    }
    var maxItem = 0
    for (startNode in 1..n) {
        val q = ArrayDeque<IntArray>()
        q.addLast(intArrayOf(0, startNode))
        val visited = IntArray(n+1) { m }
        visited[startNode] = 0
        val nodes = mutableSetOf<Int>()
        while(q.isNotEmpty()) {
            val (totalDist, node) = q.removeFirst()
            nodes.add(node)
            links[node].forEach {(nextNode, nextDist) ->
                if(totalDist+nextDist <= visited[nextNode]) {
                    visited[nextNode] = totalDist+nextDist
                    q.addLast(intArrayOf(totalDist+nextDist, nextNode))
                }
            }
        }
        var itemSum = 0
        nodes.forEach { itemSum += items[it] }
        maxItem = if (maxItem<itemSum) itemSum else maxItem
    }
    println(maxItem)
}