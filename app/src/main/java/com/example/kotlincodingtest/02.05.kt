package com.example.kotlincodingtest.file0205

/**
백준 15787 기차가 어둠을 헤치고 은하수를 (실버2)

1. 비트마스킹으로 기차 상태를 기록
2. 명령이 끝나면 set으로 만들어 중복을 없애고 기차수를 return
*/

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map{ it.toInt() }
    val limit = 1024*1024
    val trains = Array(n+1){ 0 }
    repeat(m) {
        val commands = readLine().split(" ")
        when(commands[0]) {
            "1" -> {
                val (_, train, seat) = commands.map{ it.toInt() }
                trains[train] = trains[train] or (1 shl seat-1)
            }
            "2" -> {
                val (_, train, seat) = commands.map{ it.toInt() }
                trains[train] = trains[train] and (1 shl seat-1).inv()
            }
            "3" -> {
                val (_, train) = commands.map{ it.toInt() }
                trains[train] = trains[train] shl 1
                trains[train] %= limit
            }
            "4" -> {
                val (_, train) = commands.map{ it.toInt() }
                trains[train] = trains[train] shr 1
            }
        }
    }
    print(trains.sliceArray(1..n).toSet().size)
}