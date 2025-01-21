package com.example.kotlincodingtest

/**
백준 2467 용액 (골드5)

1. 왼쪽 포인터(lp)와 오른쪽 포인터(rp) 설정
2. 각 포인터가 가리키는 용액의 혼합 특성값 산출
3. 혼합값이 음수면 lp를 증가, 양수면 rp를 감소시키며 최소 특성값 조합 찾기
*/
import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val values = readLine().split(" ").map{ it.toInt() }.toIntArray()
    var lp = 0; var rp = n-1
    var minMv = Int.MAX_VALUE; var minLp = 0; var minRp = rp
    while (lp<rp) {
        val lv = values[lp]; val rv =values[rp]; val mv = lv+rv
        if(abs(mv)<minMv) {
            minMv = abs(mv)
            minLp = lp; minRp = rp
        }
        if(mv<0) {
            lp += 1
        } else {
            rp -= 1
        }
    }
    println(values[minLp])
    println(values[minRp])
}