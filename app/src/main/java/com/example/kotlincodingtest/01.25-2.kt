package com.example.kotlincodingtest

/**
백준 17404 RGB거리 2 (골드4)

1. RGB거리 1 문제와 똑같이 dp로 접근, 다만 조건이 추가됐으므로 시작색깔이 다른 dp테이블 세개를 활용
2. 1, 2번째 값까지 갱신된 dp table 생성(성립할 수 없는 경우 무한대의 비용 산정)
3. 3번째 이상의 순서에서는 각각 dp table을 갱신하고, 마지막 N번째 경우만 따로 계산
4. 각 dp table에서 최소비용을 찾아 출력
 */

import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val costs = Array(n) { intArrayOf() }
    repeat(n) {
        costs[it] = readLine().split(" ").map{ it.toInt() }.toIntArray()
    }
    var dpR = intArrayOf(Int.MAX_VALUE, costs[0][0]+costs[1][1], costs[0][0]+costs[1][2])
    var dpG = intArrayOf(costs[0][1]+costs[1][0], Int.MAX_VALUE, costs[0][1]+costs[1][2])
    var dpB = intArrayOf(costs[0][2]+costs[1][0], costs[0][2]+costs[1][1], Int.MAX_VALUE)
    if (n>2) {
        for(idx in 2 until n-1) {
            val (costR, costG, costB) = costs[idx]
            dpR = intArrayOf(min(dpR[1], dpR[2])+costR, min(dpR[0], dpR[2])+costG, min(dpR[0], dpR[1])+costB)
            dpG = intArrayOf(min(dpG[1], dpG[2])+costR, min(dpG[0], dpG[2])+costG, min(dpG[0], dpG[1])+costB)
            dpB = intArrayOf(min(dpB[1], dpB[2])+costR, min(dpB[0], dpB[2])+costG, min(dpB[0], dpB[1])+costB)
        }
        dpR = intArrayOf(Int.MAX_VALUE, min(dpR[0], dpR[2])+costs.last()[1], min(dpR[0], dpR[1])+costs.last()[2])
        dpG = intArrayOf(min(dpG[1], dpG[2])+costs.last()[0], Int.MAX_VALUE, min(dpG[0], dpG[1])+costs.last()[2])
        dpB = intArrayOf(min(dpB[1], dpB[2])+costs.last()[0], min(dpB[0], dpB[2])+costs.last()[1], Int.MAX_VALUE)
    }
    print(intArrayOf(dpR.min(), dpG.min(), dpB.min()).min())
}