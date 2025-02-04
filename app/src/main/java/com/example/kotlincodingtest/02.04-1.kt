package com.example.kotlincodingtest.file0204_1

/**
백준 1005 ACM Craft (골드3)

1. 위상정렬 알고리즘을 활용
2. dp table을 운영해, 각 노드까지의 최소 빌드시간을 기록
*/

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    fun solution(operations: Array<String>): IntArray {
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>{ a, b -> b.compareTo(a) }
        val minHeapRemoved = mutableMapOf<Int, Int>()
        val maxHeapRemoved = mutableMapOf<Int, Int>()
        for(operation in operations) {
            val (o, v) = operation.split(" ")
            when {
                o=="I" -> {
                    val x = v.toInt()
                    minHeap.add(x)
                    maxHeap.add(x)
                    minHeapRemoved.putIfAbsent(x, 0)
                    maxHeapRemoved.putIfAbsent(x, 0)
                }
                v=="1" -> {
                    while(maxHeap.isNotEmpty() && minHeapRemoved[maxHeap.peek()]!!>0) {
                        minHeapRemoved[maxHeap.peek()] = minHeapRemoved[maxHeap.peek()]!!-1
                        maxHeap.remove()
                    }
                    val removedValue = maxHeap.remove()
                    maxHeapRemoved[removedValue] = maxHeapRemoved[removedValue]!!+1
                }
                v=="-1" -> {
                    while(minHeap.isNotEmpty() && maxHeapRemoved[minHeap.peek()]!!>0) {
                        maxHeapRemoved[minHeap.peek()] = maxHeapRemoved[minHeap.peek()]!!-1
                        minHeap.remove()
                    }
                    val removedValue = minHeap.remove()
                    minHeapRemoved[removedValue] = minHeapRemoved[removedValue]!!+1

                }
            }
        }
        while(maxHeap.isNotEmpty() && minHeapRemoved[maxHeap.peek()]!!>0) {
            minHeapRemoved[maxHeap.peek()] = minHeapRemoved[maxHeap.peek()]!!-1
            maxHeap.remove()
        }
        while(minHeap.isNotEmpty() && maxHeapRemoved[minHeap.peek()]!!>0) {
            maxHeapRemoved[minHeap.peek()] = maxHeapRemoved[minHeap.peek()]!!-1
            minHeap.remove()
        }
        return intArrayOf(
            if(maxHeap.isNotEmpty()) maxHeap.remove() else 0,
            if(minHeap.isNotEmpty()) minHeap.remove() else 0,
        )
    }

    solution(arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"))
}