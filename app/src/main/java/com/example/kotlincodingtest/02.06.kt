package com.example.kotlincodingtest.file0206

/**
*/

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, _) = readLine().split(" ").map{ it.toInt() }
    val exArr = Array(n+1){ if(it>0) readLine().toInt() else 0 }
    val newArr = Array(m+1){ if(it>0) readLine().toInt() else 0 }
    var answerCnt = 0; var answerCost = 0; var newFloor = 1
    for(exFloor in 1..n) {
        var itemCnt = exArr[exFloor]
        while(itemCnt>0 && newFloor<=m) {
            if(itemCnt<newArr[newFloor]) {
                answerCnt += itemCnt
                answerCost += (exFloor+newFloor)*itemCnt
                newArr[newFloor] -= itemCnt
                itemCnt = 0
            } else {
                answerCnt += newArr[newFloor]
                answerCost += (exFloor+newFloor)*newArr[newFloor]
                itemCnt -= newArr[newFloor]
                newFloor += 1
            }
        }
        if(itemCnt>0 || newFloor>m) break
    }
    print("$answerCnt $answerCost")
}