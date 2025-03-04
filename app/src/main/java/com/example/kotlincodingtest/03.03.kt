package com.example.kotlincodingtest.file0303

/**
 * 백준 17236 Heights (골드 4)
 *
 * 1. 단순 수학 계산
*/
import kotlin.math.*

fun main() {
    val (h1, h2, h3) = Array(3){ readln().toDouble() }
    val k = 1.0/h1 + 1.0/h2 + 1.0/h3
    print(1.0/sqrt(k * (k-2.0/h1) * (k-2.0/h2) * (k-2.0/h3)))
}