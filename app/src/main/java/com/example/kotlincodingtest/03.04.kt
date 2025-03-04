package com.example.kotlincodingtest.file0304

/**
 * 백준 15919 사자는 여행왕이야!! (골드 3)
 *
 * 1. 단순 수학 계산
*/
import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val arr = Array(m) { readLine().split(" ").map{ it.toInt() }.toTypedArray() }
    val sortedArr = arr.sortedWith(compareBy({it.first()}, {it.last()})).toTypedArray()
    val dp = Array(m){ Int.MAX_VALUE }

    fun dfs(idx: Int, today: Int): Int {

    }
}