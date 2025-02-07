package com.example.kotlincodingtest.file0206

/**
백준 15787 기차가 어둠을 헤치고 은하수를 (실버2)

1. 비트마스킹으로 기차 상태를 기록
2. 명령이 끝나면 set으로 만들어 중복을 없애고 기차수를 return
1 1 1
1
0
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