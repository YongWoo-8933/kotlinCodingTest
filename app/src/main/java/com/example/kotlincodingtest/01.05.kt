package com.example.kotlincodingtest

/**
백준 9935 문자열 폭발 (골드4)

1. stack에 문자열 추가
2. stack 마지막 부분에 폭발 문자열이 있다면 뽑아냄
*/

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    val ptn = readLine()
    val stack = StringBuilder()
    for (s in str) {
        stack.append(s)
        if (stack.endsWith(ptn)) {
            stack.delete(stack.length-ptn.length, stack.length)
        }
    }
    if(stack.isNotEmpty()) {
        print(stack)
    } else {
        print("FRULA")
    }
}