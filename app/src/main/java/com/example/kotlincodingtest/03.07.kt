package com.example.kotlincodingtest.file0307

/**
 * 백준 23631 진심 좌우 반복뛰기 (실버 1)
 *
 * 1. 이차방정식으로 i를 찾고 해당하는 위치와 방향을 구하면 됨.
*/
import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (n, k) = readLine().split(" ").map{ it.toInt() }
        val i = ((-1.0+sqrt(1.0+8.0*(n.toDouble()-1.0)/k.toDouble()))/2.0).toInt()
        val sb = StringBuilder()
        if(i%2==0) {
            sb.appendLine("${-(i/2)*k+(n-1-k*i*(i+1)/2)} R")
        } else {
            sb.appendLine("${(i/2+1)*k-(n-1-k*i*(i+1)/2)} L")
        }
        print(sb.toString())
    }
}