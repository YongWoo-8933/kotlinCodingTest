package com.example.kotlincodingtest.file0304

/**
 * 백준 15919 사자는 여행왕이야!! (골드 3)
 *
 * 1. dp+dfs조합으로 풀이
 * 2. 먼저 여행 시작일자 순으로 일정 정렬
 * 3. dfs로 모든 일정을 순회함.
 * 4. 이때 dp로 특정 여행을 갈 경우 이후 나올 수 있는 최소 간격을 저장해둠
*/
import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val arr = Array(m) { readLine().split(" ").map{ it.toInt() }.toTypedArray() }
    val sortedArr = arr.sortedWith(compareBy({it.first()}, {it.last()})).toTypedArray()
    val dp = Array(m){ Int.MAX_VALUE }

    fun dfs(idx: Int, today: Int): Int {
        if(idx==m) return n-today
        val (fr, to) = sortedArr[idx]
        if(fr<=today) return dfs(idx+1, today)
        if(dp[idx]==Int.MAX_VALUE) dp[idx] = dfs(idx+1, to)
        return min(dfs(idx+1, today), max(fr-today-1, dp[idx]))
    }

    print(dfs(0, 0))
}