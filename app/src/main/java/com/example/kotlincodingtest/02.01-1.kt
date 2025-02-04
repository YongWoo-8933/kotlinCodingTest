package com.example.kotlincodingtest.file0201_1

/**
백준 1806 부분합 (골드4)

1. 수열합의 범위를 지정할 좌우 포인터 lp, rp와 수열합 sequence_sum을 0, 0, 0으로 설정
2. sequence_sum이 S보다 작으면 sequence[rp]값은 수열합에 더하고 rp를 오른쪽으로 이동
3. sequence_sum이 S보다 커지면 answer를 갱신하고 수열합에서 sequence[lp]값을 뺀 뒤 lp를 오른쪽으로 이동
4. lp가 rp보다 커지거나 rp가 범위를 벗어나면 종료
 */

import kotlin.math.*

fun main() {
    val (n, s) = readln().split(" ").map{ it.toInt() }
    val lst = readln().split(" ").map{ it.toInt() }.toIntArray()
    var answer = Int.MAX_VALUE
    var lp = 0; var rp = 0; var sum = 0
    while(lp<=rp) {
        when {
            sum<s && rp<n -> {
                sum += lst[rp]
                rp += 1
            }
            s<=sum -> {
                answer = min(answer, rp-lp)
                sum -= lst[lp]
                lp += 1
            }
            else -> break
        }
    }
    print(if(answer==Int.MAX_VALUE) 0 else answer)
}