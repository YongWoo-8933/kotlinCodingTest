package com.example.kotlincodingtest.file0317

/**
백준 1277 발전소 설치 (골드 4)

1. 다익스트라 태그 힌트 받고 품
2. 각 좌표를 저장해놓고, 연결된 발전소 정보 저장
3. 1에서부터 시작해 모든 발전소로의 이동정보를 hq에 추가
4. heapq로 구현함으로써 항상 가장 적은 비용을 가지는 이동이 먼저 실행되도록함
5. visited를 저장할 때 각 노드로 이동하는 최소비용을 저장해 시행횟수 제한
*/
import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, w) = readLine().split(" ").map{ it.toInt() }
    val m = readLine().toDouble()
    val points = Array(n+1){ intArrayOf(0, 0) }
    repeat(n) {
        val (x, y) = readLine().split(" ").map{ it.toInt() }
        points[it+1][0] = x; points[it+1][1] = y
    }
    val links = Array(n+1){ mutableSetOf<Int>() }
    repeat(w) {
        val (fr, to) = readLine().split(" ").map{ it.toInt() }
        links[fr].add(to)
        links[to].add(fr)
    }
}