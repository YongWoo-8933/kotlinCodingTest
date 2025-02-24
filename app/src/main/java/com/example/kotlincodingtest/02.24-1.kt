package com.example.kotlincodingtest.file0224_1

/**
 * 백준 1535 안녕 (실버2)
 *
 * 1. 완전탐색으로 모든 경우 체크
*/
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val lost = readln().split(" ").map{ it.toInt() }.toTypedArray()
    val gain = readln().split(" ").map{ it.toInt() }.toTypedArray()
    var answer = 0

    fun dfs(idx: Int, hp: Int, joy: Int) {
        if(idx==n) {
            answer = max(answer, joy)
            return
        }
        dfs(idx+1, hp, joy)
        val newHp = hp-lost[idx]; val newJoy = joy+gain[idx]
        if(newHp>0) dfs(idx+1, newHp, newJoy)
    }

    dfs(0, 100, 0)
    print(answer)
}