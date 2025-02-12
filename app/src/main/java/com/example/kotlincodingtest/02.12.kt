package com.example.kotlincodingtest.file0212

/**
 * 백준 2149 암호 해독 (실버3)
 *
 * 1. 조건에 맞게 하드코딩하면 됨
*/

fun main() = with(System.`in`.bufferedReader()) {
    val key = readLine().trim()
    val sortedCharIndexPair = key.indices.map{ Pair(key[it], it) }.sortedBy { it.first }.toTypedArray()
    val sortedIndexMap = sortedCharIndexPair.indices.associateBy { sortedCharIndexPair[it].second }
    val strOrigin = readLine().trim()
    val strChanged = StringBuilder()
    val rowNum = strOrigin.length/key.length
    for(i in 0 until rowNum) {
        for(j in key.indices) {
            strChanged.append(strOrigin[j*rowNum+i])
        }
    }
    val answer = StringBuilder()
    for(row in 0 until rowNum) {
        for(idx in key.indices) {
            answer.append(strChanged[row*key.length+sortedIndexMap[idx]!!])
        }
    }
    print(answer.toString())
}