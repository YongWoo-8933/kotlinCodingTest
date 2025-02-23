package com.example.kotlincodingtest.file0223

/**
 * 백준 3258 컴포트 (실버3)
 *
 * 1. 한바퀴 돌고 무한루프에 빠지는 경우를 고려해서 구현하면 됨
*/

fun main() {
    val (n, z, _) = readln().split(" ").map{ it.toInt() }
    val traps = readln().split(" ").map{ it.toInt() }.toSet()
    loop1@
    for(k in 1 until z) {
        var pos = 0
        while(pos+1!=z) {
            pos += k
            pos %= n
            if(pos==0) continue@loop1
            if(pos+1 in traps) continue@loop1
        }
        print(k)
        break
    }
}