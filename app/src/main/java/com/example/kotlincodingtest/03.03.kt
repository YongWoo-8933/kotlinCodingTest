package com.example.kotlincodingtest.file0303

/**
 * 백준 17236 Heights (골드 4)
 *
 * 1. 순회하며 단순 확률계산
*/
import kotlin.math.*

fun main() {
    val (h1, h2, h3) = Array(3){ readln().toDouble() }
    print(2.0/(1.0/h1+1.0/h2+1.0/h3))
}