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
import kotlin.math.sqrt

// 다익스트라 순회에 사용될 탐색 유닛
data class SearchUnit(val length: Double, val nodeIndex: Int)

fun main() = with(System.`in`.bufferedReader()) {
    // 입력 받기
    val (n, w) = readLine().split(" ").map{ it.toInt() }
    val m = readLine().toDouble()
    val points = Array(n){ readLine().split(" ").map{ it.toInt() }.toTypedArray() }
    val links = Array(n){ mutableSetOf<Int>() }
    repeat(w) {
        val (fr, to) = readLine().split(" ").map{ it.toInt() }
        links[fr-1].add(to-1)
        links[to-1].add(fr-1)
    }

    // Heap 생성
    val hq = PriorityQueue<SearchUnit>{ a, b -> a.length.compareTo(b.length) }
    hq.add(SearchUnit(0.0, 0))

    // 방문체크 초기화
    val visited = Array(n){ Double.MAX_VALUE }
    visited[0] = 0.0

    // 탐색 시작
    while(hq.isNotEmpty()) {
        val su = hq.remove()
        // 마지막 발전소까지 탐색 끝나면 종료
        if(su.nodeIndex==n-1) {
            print((su.length * 1000.0).toInt())
            break
        }
        // 이미 연결 되어 있다면 연결된 발전소 Heap에 추가
        for(nextNode in links[su.nodeIndex]) {
            if(su.length<visited[nextNode]) {
                visited[nextNode] = su.length
                hq.add(SearchUnit(su.length, nextNode))
            }
        }
        // 연결 되어 있지 않은 발전소는 전선 길이 체크 후 Heap에 추가
        val (x, y) = points[su.nodeIndex].map { it.toDouble() }
        for(nextNode in 0 until n) {
            val (nx, ny) = points[nextNode]
            val dx = nx-x; val dy = ny-y
            val l = sqrt(dx*dx+dy*dy)
            val newLength = su.length+l
            if(l<=m && newLength<visited[nextNode]) {
                visited[nextNode] = newLength
                hq.add(SearchUnit(newLength, nextNode))
            }
        }
    }
}