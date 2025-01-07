package com.example.kotlincodingtest

/**
백준 16236 아기 상어 (골드3)

1. 시작 지점(9) 부터 BFS시작
2. 먹을 수 있는 물고기를 만나면 eatable_fish 리스트에 좌표와 거리 추가
3-1. BFS 종료후 먹을 수 있는 물고기가 없으면 종료
3-2. 먹을 수 있는 물고기가 있다면, 물고기중 가장 가까운>위의>왼쪽의 물고기 선정
4. 해당 물고기를 먹고 + 먹은자리 비우기 + BFS 시작좌표 갱신 + 총소요시간 갱신
5. 상어가 먹은 물고기수 체크 > 사이즈만큼 먹으면 사이즈업
*/

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = Array(n) { IntArray(n){ 0 } }
    var (startRow, startCol) = intArrayOf(0, 0)
    for (i in 0 until n) {
        val lst = readLine().split(" ").map{ it.toInt() }
        for (j in 0 until n) {
            if (lst[j]==9) {
                startRow = i
                startCol = j
            } else {
                map[i][j] = lst[j]
            }
        }
    }
    var (totalTime, currentSize, eatFishNum) = intArrayOf(0, 2, 0)
    while(true) {
        val q = ArrayDeque<IntArray>()
        q.addLast(intArrayOf(0, startRow, startCol))
        val visited = Array(n) { BooleanArray(n) { false } }
        visited[startRow][startCol] = true
        val eatableFish = arrayListOf<IntArray>()
        while(q.isNotEmpty()) {
            val (time, row, col) = q.removeFirst()
            if (map[row][col] in 1 until currentSize) {
                eatableFish.add(intArrayOf(row, col, time))
                continue
            }
            for ((nextRow, nextCol) in listOf(listOf(row+1, col), listOf(row-1, col), listOf(row, col+1), listOf(row, col-1))) {
                if(nextRow in 0 until n && nextCol in 0 until n && !visited[nextRow][nextCol] && map[nextRow][nextCol]<=currentSize) {
                    visited[nextRow][nextCol] = true
                    q.addLast(intArrayOf(time+1, nextRow, nextCol))
                }
            }
        }
        if (eatableFish.isNotEmpty()) {
            var (minRow, minCol, minTime) = eatableFish[0]
            for (idx in 1 until eatableFish.size) {
                val (i, j, t) = eatableFish[idx]
                if (t<minTime || (t==minTime && (i<minRow ||(i==minRow && j<minCol)))) {
                    minRow = i; minCol = j; minTime = t
                }
            }
            map[minRow][minCol] = 0
            totalTime += minTime
            startRow = minRow; startCol = minCol
            eatFishNum += 1
            if (eatFishNum==currentSize) {
                currentSize += 1
                eatFishNum = 0
            }
        } else {
            break
        }
    }
    print(totalTime)
}