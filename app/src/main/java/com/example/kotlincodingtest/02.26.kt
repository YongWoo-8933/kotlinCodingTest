package com.example.kotlincodingtest.file0226

/**
 * 백준 9358 순열 접기 게임 (실버5)
 *
 * 1. 단순 구현
*/
import kotlin.math.ceil

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) { tc ->
        var n = readLine().toInt()
        var arr = readLine().split(" ").map{ it.toLong() }.toTypedArray()
        while(n>2) {
            n = ceil(n.toDouble()/2.0).toInt()
            arr = (0 until n).map{ arr[it]+arr[arr.size-1-it] }.toTypedArray()
        }
        if (arr[0]>arr[1]) {
            sb.appendLine("Case #${tc+1}: Alice")
        } else {
            sb.appendLine("Case #${tc+1}: Bob")
        }
    }
    print(sb.toString())
}