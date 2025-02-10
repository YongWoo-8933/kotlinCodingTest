package com.example.kotlincodingtest.file0210

import kotlin.system.exitProcess
import kotlin.math.*

/**
 * 백준 17140 이차원 배열과 연산 (골드4)
 *
 * 1. 하드코딩으로 구현하면 됨. (정렬 연산 활용)
*/

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c, k) = readLine().split(" ").map{ it.toInt() }
    var h = 3; var w = 3
    var arr = Array(h){ readLine().split(" ").map{ it.toInt() }.toIntArray() }
    repeat(101) { sec ->
        if(r<=h && c<=w && arr[r-1][c-1]==k) {
            print(sec)
            exitProcess(0)
        }
        if(h>=w) {
            // R 연산
            val rows = Array(h){ mutableListOf<Int>() }
            var maxWidth = 0
            for(row in 0 until h) {
                val map = mutableMapOf<Int, Int>()
                for(col in 0 until w) {
                    val x = arr[row][col]
                    if(x==0) continue
                    map.putIfAbsent(x, 0)
                    map[x] = map[x]!!+1
                }
                val sortedRow = map.toList().sortedWith(compareBy({ it.second }, { it.first }))
                for((num, cnt) in sortedRow) {
                    rows[row].add(num)
                    rows[row].add(cnt)
                }
                maxWidth = max(maxWidth, rows[row].size)
            }
            w = min(maxWidth, 100)
            arr = Array(h){ IntArray(w){ 0 } }
            for(row in 0 until h) {
                for(col in rows[row].indices) {
                    arr[row][col] = rows[row][col]
                    if(col>99) break
                }
            }
        } else {
            // C 연산
            val cols = Array(w){ mutableListOf<Int>() }
            var maxHeight = 0
            for(col in 0 until w) {
                val map = mutableMapOf<Int, Int>()
                for(row in 0 until h) {
                    val x = arr[row][col]
                    if(x==0) continue
                    map.putIfAbsent(x, 0)
                    map[x] = map[x]!!+1
                }
                val sortedCol = map.toList().sortedWith(compareBy({ it.second }, { it.first }))
                for((num, cnt) in sortedCol) {
                    cols[col].add(num)
                    cols[col].add(cnt)
                }
                maxHeight = max(maxHeight, cols[col].size)
            }
            h = min(maxHeight, 100)
            arr = Array(h){ IntArray(w){ 0 } }
            for(col in 0 until w) {
                for(row in cols[col].indices) {
                    if(row>99) break
                    arr[row][col] = cols[col][row]
                }
            }
        }
    }
    print(-1)
}