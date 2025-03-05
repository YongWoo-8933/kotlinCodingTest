package com.example.kotlincodingtest.file0305

/**
 * 프로그래머스 합승택시요금 (level3)
 *
 * 1. 플로이드-워셜 알고리즘으로 각 노드간 최단비용을 미리 구함
 * 2. 두 사람이 헤어질 곳(경유지)을 정하고, 그곳을 기준으로 택시비 산정
 * 3. 경유지를 1~n까지 순회하며 최소 택시비용 찾기
*/
import kotlin.math.min

class Solution {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        val INF = 199*100000+1
        val distance = Array(n+1) { Array(n+1) { INF } }
        // 대각선 초기화
        for (i in 1..n) {
            distance[i][i] = 0
        }
        // 간선 정보 초기화
        for ((c, d, f) in fares) {
            distance[c][d] = f
            distance[d][c] = f
        }
        // 플로이드 워셜 알고리즘
        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    distance[i][j] = min(distance[i][j], distance[i][k]+distance[k][j])
                }
            }
        }
        // 경유지 들러 도착하는 택시요금 계산
        var answer = INF
        for (k in 1..n) {
            answer = min(answer, distance[s][k]+distance[k][a]+distance[k][b])
        }
        return answer
    }
}