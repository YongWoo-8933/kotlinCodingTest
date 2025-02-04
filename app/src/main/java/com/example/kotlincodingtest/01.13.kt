package com.example.kotlincodingtest.file0113

/**
백준 2636 치즈 (골드4)

1. 매 시간마다 외부공기 마킹 -> 인접치즈 녹이기
*/

fun main() = with(System.`in`.bufferedReader()) {
    val (h, w) = readLine().split(" ").map{ it.toInt() }
    val map = Array(h) { Array(w) { 0 } }
    for (r in 0 until h) {
        val lst = readLine().split(" ").map{ it.toInt() }
        for (c in 0 until w) {
            map[r][c] = lst[c]
        }
    }
    var hours = 0
    var lastCheeseCount = 0
    while(true) {
        // 치즈가 있는지 확인
        var cheeseCount = 0
        for(i in 0 until h) {
            for(j in 0 until w) {
                if(map[i][j]==1) {
                    cheeseCount += 1
                }
            }
        }
        if(cheeseCount==0) {
            break
        } else {
            lastCheeseCount = cheeseCount
        }
        hours += 1
        // 외부 공기 구분용 BFS
        var startRow = -1; var startCol = -1
        for (i in arrayOf(0, h-1)) {
            for (j in 0 until w) {
                if (map[i][j]==0) {
                    startRow = i; startCol = j
                }
            }
        }
        for (j in arrayOf(0, w-1)) {
            for (i in 0 until h) {
                if (map[i][j]==0) {
                    startRow = i; startCol = j
                }
            }
        }
        val q = ArrayDeque<IntArray>()
        q.addLast(intArrayOf(startRow, startCol))
        val externalArea = Array(h) { Array(w) { 0 } }
        externalArea[startRow][startCol] = 1
        while(q.isNotEmpty()) {
            val (row, col) = q.removeFirst()
            for((newRow, newCol) in arrayOf(arrayOf(row+1, col), arrayOf(row-1, col), arrayOf(row, col+1), arrayOf(row, col-1))) {
                if(newRow in 0 until h && newCol in 0 until w && externalArea[newRow][newCol]==0) {
                    externalArea[newRow][newCol] = 1
                    if(map[newRow][newCol]==0) {
                        q.addLast(intArrayOf(newRow, newCol))
                    } else if (map[newRow][newCol]==1) {
                        map[newRow][newCol] = 2
                    }
                }
            }
        }
        // 접한 치즈 녹이기
        for (i in 0 until h) {
            for (j in 0 until w) {
                if (map[i][j]==2) {
                    map[i][j] = 0
                }
            }
        }
    }
    println(hours)
    println(lastCheeseCount)
}