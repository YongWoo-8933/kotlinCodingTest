package com.example.kotlincodingtest.file0124_2

/**
백준 2239 스도쿠 (골드4)

1. 백트래킹 알고리즘 구현
2. 행, 열, 칸 숫자의 중복을 피하기 위해 각각 set을 만들어둠
3. 0번째 ~ 80번째 칸까지 idx부여, 각 칸에대한 back_tracking 함수 실행
4. 각 실행에서는 해당 칸이 비어있을 경우(0인경우) 숫자 1~9에대한 back_tracking 실행
5. idx가 80보다 커지면 정답 배열을 출력하고 exit을 통해 초과 출력 방지
 */

import kotlin.system.exitProcess

fun main() {
    val board = Array(9) { Array(9) { 0 } }
    val rowCheck = Array(9) { BooleanArray(9) { false } }
    val colCheck = Array(9) { BooleanArray(9) { false } }
    val blockCheck = Array(9) { BooleanArray(9) { false } }

    for (i in 0 until 9) {
        val s = readln()
        for (j in 0 until 9) {
            val x = s[j].toString().toInt()
            if (x!=0) {
                board[i][j] = x
                rowCheck[i][x-1] = true
                colCheck[j][x-1] = true
                blockCheck[(i/3)*3+j/3][x-1] = true
            }
        }
    }

    fun backTracking(idx: Int) {
        if (idx>80) {
            val sb = StringBuilder()
            repeat(9) {
                sb.appendLine( board[it].joinToString("") )
            }
            print(sb)
            exitProcess(0)
        }
        val row = idx/9; val col = idx%9; val block = (row/3)*3+col/3
        if(board[row][col]!=0) {
            backTracking(idx+1)
        } else {
            for(x in 0 until 9) {
                if (!rowCheck[row][x] && !colCheck[col][x] && !blockCheck[block][x]) {
                    board[row][col] = x+1
                    rowCheck[row][x] = true
                    colCheck[col][x] = true
                    blockCheck[block][x] = true
                    backTracking(idx+1)
                    board[row][col] = 0
                    rowCheck[row][x] = false
                    colCheck[col][x] = false
                    blockCheck[block][x] = false
                }
            }
        }
    }

    backTracking(0)
}