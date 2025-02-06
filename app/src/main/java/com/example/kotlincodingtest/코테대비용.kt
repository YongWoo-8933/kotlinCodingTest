package com.example.kotlincodingtest.test

import java.util.*
import kotlin.math.*
import kotlin.system.exitProcess

fun main() {
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // Int, Long 범위 제발 확인하기!!!!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


    // 정렬 메소드
    val lst = mutableListOf(1, 2, 4, 3)
    lst.sorted()
    lst.sortedDescending()
    lst.sortedBy { it.toLong() }
    lst.sortedByDescending { it.toDouble() }
    lst.sortedWith( compareBy { it.toString() } )
    lst.sortedWith( compareByDescending { it.toString() } )
    lst.sortedWith( compareBy({ it.toString() }, { it.toLong() }) )
    lst.sortedWith( compareBy<Int> { it.toString() }.thenByDescending { it.toLong() } )

    // Map 사용법
    // [] 사용해 값 얻을땐 반드시 null 체크 할 것!
    val map = mutableMapOf(1 to "1", 2 to "2", 3 to "3", 4 to "4")
    map.toList() // 반환형: List<Pair<K, V>>
    map.entries //  반환형: MutableSet<MutableMap.MutableEntry<K, V>>
    map.keys // 반환형: MutableSet<K>
    map.values // 반환형: MutableCollection<V>
    map.putIfAbsent(4, "5") // 4에 값이 있으므로 무시
    map.putIfAbsent(5, "5") // 5에 값이 없으므로 셋
    map.getOrDefault(6, 0) // 6에 값이 없으므로 0반환
    map.getOrDefault(1, 0) // 1에 값이 있으므로 1반환

    // Set
    val set = mutableSetOf(3, 3, 2, 4)
    set.addAll(mutableSetOf(1, 1, 3, 5))
    set.removeAll(mutableSetOf(1, 1, 3, 5))

    // 배열 메소드
    lst.sum()
    lst.sumOf { it%2 }
    lst.maxOf { it*3 }
    lst.minOf { it*3 }
    lst.filter{ it%2==0 }.sum()

    // 배열 슬라이싱
    lst.subList(0, 4)  // 원본에 영향 o
    lst.slice(0..3)  // 원본에 영향 x, 새 리스트 생성 하는 것임
    lst.take(10)  // 인덱스 안맞춰도 됨
    lst.takeLast(10)  // 인덱스 안맞춰도 됨, 뒷부분 take
    lst.drop(10)  // 인덱스 안맞춰도 됨
    lst.dropLast(10)  // 인덱스 안맞춰도 됨, 뒷부분 drop

    // 우선 순위 큐
    // offer, poll, peek 사용시 null체크 확실히 할것!
    val hq1 = PriorityQueue<Int> { a, b -> b.compareTo(a) }  // maxHeap
    val hq2 = PriorityQueue<Pair<Int, Int>> { a, b -> a.second.compareTo(b.second) }  // 두번째 요소로 비교
    val hq3 = PriorityQueue(compareBy<Pair<Int, Int>>({ it.second }, { it.second }))  // 두번째 요소로 비교한 후, 같을때 첫번째 요소로 비교
    val hq4 = PriorityQueue(compareBy<Pair<Int, Int>>{ it.second }.thenByDescending{ it.first })  // 두번째 요소로 비교한 후, 같을때 첫번째 요소 내림차순 비교

    // 비트마스킹
    var bits = 37
    bits = bits or (1 shl 2) // 세번째 비트 켜기
    bits = bits and (1 shl 2).inv() // 세번째 비트 끄기
    val isSame = bits == (bits or (1 shl 2)) // 세번째 비트 켜져 있는지 확인
    bits = bits xor (1 shl 2) // 세번째 비트 토글

    // math 메소드
    2.0.pow(30)
    sqrt(36.0)
    log(8.0, 2.0)
    log2(9.0)
    abs(-3)

    // str 관련 메소드
    val sb = StringBuilder()
    sb.append("x")
    sb.appendLine("xxs")
    sb.startsWith("dsds")
    sb.endsWith("dsds")
    sb.delete(1, 3)  // 1 until 3
    sb.indexOf("s")
    sb.replace(0, 3, "fs")
    "dWgwgWAF".uppercase()
    "dWgwgWAF".lowercase()
    'F'.isUpperCase()
    'F'.isLowerCase()
    "Fdsafdsa".indexOf('a')
    // 프로그램 종료
    exitProcess(0)
}