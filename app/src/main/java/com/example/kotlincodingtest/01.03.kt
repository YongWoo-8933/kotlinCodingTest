package com.example.kotlincodingtest.file0103

/**
백준 12851 숨바꼭질 2 (골드4)

1. BFS를 통한 완전탐색
2. 동생의 위치가 더 작거나 같으면 걸어가는 경우가 항상 가장 빠르므로 N-K
3. 동생의 위치가 더 클경우, 걷는 경우와 순간이동하는 경우를 queue에 추가
4. check 리스트로 각 node에서의 최소시간을 update해 queue에 중복 없게함
5. 최단시간이 나오면 그 후로는 종료
*/

fun main() = with(System.`in`.bufferedReader())  {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    if (n>=k) {
        println(n-k)
        println(1)
        return
    }
    val q = ArrayDeque<IntArray>()
    q.addLast(intArrayOf(0, n))
    val check = MutableList(k+2) { 1000000 }
    check[n] = 0
    var count = 0
    while(q.isNotEmpty()) {
        var (totalSec, node) = q.removeFirst()
        if (node==k) {
            count += 1
            continue
        }
        totalSec += 1
        for (nextNode in intArrayOf(node+1, node-1, node*2)) {
            if (0<=nextNode && nextNode<k+2 && totalSec<=check[nextNode]) {
                check[nextNode] = totalSec
                q.addLast(intArrayOf(totalSec, nextNode))
            }
        }
    }
    println(check[k])
    println(count)
}