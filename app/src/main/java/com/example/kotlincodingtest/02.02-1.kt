package com.example.kotlincodingtest.file0202_1

/**
백준 2143 두 배열의 합 (골드3)

1. 누적합 방법을 이용해 A의 모든 i~j번째 합을 구함 (O(n^2))
2. 수열 A에대한 누적합을 진행하면서, dict를 하나 만들어 각 합값이 몇개인지 기록
ex) 1~4수열합이 6, 4~5수열합이 1, 7~8수열합이 6이었다면, dict = {6: 2, 1: 1}
3. 수열 B에대한 누적합을 진행하면서, "T-누적합"이 위에서 만든 dict의 key로 존재한다면, 그 value값만큼 count
*/

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toLong()
    readLine()
    val lstA = readLine().split(" ").map{ it.toLong() }.toLongArray()
    readLine()
    val lstB = readLine().split(" ").map{ it.toLong() }.toLongArray()
    val sumA = mutableListOf<Long>()
    val sumAMap = mutableMapOf<Long, Long>()
    for(x in lstA) {
        for(j in sumA.indices) {
            sumA[j] += x
            sumAMap[sumA[j]] = sumAMap.getOrDefault(sumA[j], 0L)+1L
        }
        sumA.add(x)
        sumAMap[x] = sumAMap.getOrDefault(x, 0L)+1L
    }
    val sumB = mutableListOf<Long>()
    var answer = 0L
    for(x in lstB) {
        for(j in sumB.indices) {
            sumB[j] += x
            answer += sumAMap.getOrDefault(t-sumB[j], 0L)
        }
        sumB.add(x)
        answer += sumAMap.getOrDefault(t-x, 0L)
    }
    print(answer)
}