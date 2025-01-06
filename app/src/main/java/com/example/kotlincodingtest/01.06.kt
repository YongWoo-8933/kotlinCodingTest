package com.example.kotlincodingtest

/**
백준 17144 미세먼지 안녕! (골드4)

1. 하드코딩 시뮬레이션
*/

fun diffuse(
    width: Int,
    height: Int,
    originMap: Array<IntArray>
): Array<IntArray> {
    val newMap = Array(height) { IntArray(width) { 0 } }
    for(row in 0 until height) {
        for(col in 0 until width) {
            val dust = originMap[row][col]
            val newDust = dust/5
            var count = 0
            if(newDust>0) {
                for ((newRow, newCol) in arrayOf(intArrayOf(row+1, col), intArrayOf(row-1, col), intArrayOf(row, col+1), intArrayOf(row, col-1))) {
                    if(newRow in 0 until height && newCol in 0 until width && originMap[newRow][newCol]!=-1) {
                        newMap[newRow][newCol] += newDust
                        count += 1
                    }
                }
            }
            newMap[row][col] += dust-newDust*count
        }
    }
    return newMap
}

fun topCycle(
    width: Int,
    topAcRow: Int,
    originMap: Array<IntArray>
) {
    var temp = originMap[topAcRow][1]
    originMap[topAcRow][1] = 0
    for (col in 2 until width) {
        val tmp = temp
        temp = originMap[topAcRow][col]
        originMap[topAcRow][col] = tmp
    }
    for (row in topAcRow-1 downTo  0) {
        val tmp = temp
        temp = originMap[row][width-1]
        originMap[row][width-1] = tmp
    }
    for (col in width-2 downTo 0) {
        val tmp = temp
        temp = originMap[0][col]
        originMap[0][col] = tmp
    }
    for (row in 1 until topAcRow) {
        val tmp = temp
        temp = originMap[row][0]
        originMap[row][0] = tmp
    }
}

fun bottomCycle(
    width: Int,
    height: Int,
    botAcRow: Int,
    originMap: Array<IntArray>
) {
    var temp = originMap[botAcRow][1]
    originMap[botAcRow][1] = 0
    for (col in 2 until width) {
        val tmp = temp
        temp = originMap[botAcRow][col]
        originMap[botAcRow][col] = tmp
    }
    for (row in botAcRow+1 until height) {
        val tmp = temp
        temp = originMap[row][width-1]
        originMap[row][width-1] = tmp
    }
    for (col in width-2 downTo 0) {
        val tmp = temp
        temp = originMap[height-1][col]
        originMap[height-1][col] = tmp
    }
    for (row in height-2 downTo botAcRow+1) {
        val tmp = temp
        temp = originMap[row][0]
        originMap[row][0] = tmp
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val (h, w, t) = readLine().split(" ").map{ it.toInt() }
    var map = Array(h) { IntArray(w) { 0 } }
    for(row in 0 until h) {
        val lst = readLine().split(" ").map{ it.toInt() }
        for (col in 0 until w) {
            map[row][col] = lst[col]
        }
    }
    var (topAcRow, botAcRow) = intArrayOf(0, 0)
    for(i in 0 until h) {
        if (map[i][0]==-1) {
            topAcRow = i
            botAcRow = i+1
            break
        }
    }
    repeat(t) {
        map = diffuse(width = w, height = h, originMap = map)
        topCycle(width = w, topAcRow = topAcRow, originMap = map)
        bottomCycle(width = w, height = h, botAcRow = botAcRow, originMap = map)
    }
    var answer = 0
    for(i in 0 until h) {
        answer += map[i].sum()
    }
    print(answer+2)
}