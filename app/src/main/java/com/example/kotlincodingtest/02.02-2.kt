package com.example.kotlincodingtest

/**
백준 1005 ACM Craft (골드3)

1. 위상정렬 알고리즘을 활용
2. dp table을 운영해, 각 노드까지의 최소 빌드시간을 기록
*/
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (n, k) = readLine().split(" ").map{ it.toInt() }
        val times = arrayListOf(0)
        times.addAll(readLine().split(" ").map{ it.toInt() })
        val links = Array(n+1) { mutableSetOf<Int>() }
        val inDegree = Array(n+1) { 0 }
        repeat(k) {
            val (fr, to) = readLine().split(" ").map{ it.toInt() }
            links[fr].add(to)
            inDegree[to] += 1
        }
        val target = readLine().toInt()
        val q = ArrayDeque<Int>()
        val dp = times.toIntArray().copyOf()
        for(i in 1..n) {
            if(inDegree[i]==0) {
                q.addLast(i)
            }
        }
        while(q.isNotEmpty()) {
            val node = q.removeFirst()
            for(nextNode in links[node]) {
                inDegree[nextNode] -= 1
                dp[nextNode] = max(dp[nextNode], dp[node]+times[nextNode])
                if(inDegree[nextNode]==0) {
                    q.addLast(nextNode)
                }
            }
        }
        println(dp[target])
    }
}